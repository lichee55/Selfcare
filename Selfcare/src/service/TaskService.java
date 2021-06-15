package service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import domain.Member;
import domain.Task;
import persistence.TaskRepository;

public class TaskService {
	private final TaskRepository taskRepository = TaskRepository.getInstacne();

	public TaskService() {

	}

	public void insert(Task task) {
		taskRepository.save(task);
	}

	public void delete(Task task) {
		taskRepository.delete(task);
	}

	public ArrayList<ArrayList<Task>> findTaskByDate(LocalDateTime time, int during, Member member) {
		ArrayList<Task> tasks = taskRepository.findTaskByDate(time, member);

		LocalDateTime minTime = time.minusDays(2);
		minTime = minTime.minusHours(minTime.getHour());
		minTime = minTime.minusMinutes(minTime.getMinute());
		minTime = minTime.minusSeconds(minTime.getSecond());
		minTime = minTime.minusNanos(minTime.getNano());

		LocalDateTime maxTime = time.plusDays(3);
		maxTime = maxTime.minusHours(maxTime.getHour());
		maxTime = maxTime.minusMinutes(maxTime.getMinute());
		maxTime = maxTime.minusSeconds(maxTime.getSecond());
		maxTime = maxTime.minusNanos(maxTime.getNano());

		ArrayList<ArrayList<Task>> duringTasks = new ArrayList<ArrayList<Task>>();

		int i = 0;
		while (tasks.size() > i && minTime != maxTime) {
			ArrayList<Task> daytasks = new ArrayList<Task>();
			while ((i < tasks.size()) && (minTime.getDayOfMonth() == tasks.get(i).getTaskdate().getDayOfMonth())) {
				daytasks.add(tasks.get(i));
				i++;
			}
			duringTasks.add(daytasks);
			minTime = minTime.plusDays(1);
		}
		i++;
		for (; i < 5; i++) {
			ArrayList<Task> daytasks = new ArrayList<Task>();
			duringTasks.add(daytasks);
		}

		return duringTasks;
	}
}
