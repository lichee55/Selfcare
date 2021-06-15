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

		LocalDateTime minTime = time.minusDays(during);
		minTime.minusHours(minTime.getHour());
		minTime.minusMinutes(minTime.getMinute());
		minTime.minusSeconds(minTime.getSecond());
		minTime.minusNanos(minTime.getNano());

		LocalDateTime maxTime = time.plusDays(during + 1);
		maxTime.minusHours(maxTime.getHour());
		maxTime.minusMinutes(maxTime.getMinute());
		maxTime.minusSeconds(maxTime.getSecond());
		maxTime.minusNanos(maxTime.getNano());

		ArrayList<ArrayList<Task>> duringTasks = new ArrayList<ArrayList<Task>>();

		int i = 0;
		while (tasks.size() > i) {
			if (tasks.get(i).getTaskdate().isAfter(minTime)) {
				ArrayList<Task> daytasks = new ArrayList<Task>();
				int date = tasks.get(i).getTaskdate().getDayOfMonth();
				int j = i;
				while ((tasks.get(j).getTaskdate().getDayOfMonth() == date) && (j < tasks.size())) {
					daytasks.add(tasks.get(j));
					j++;
				}
				duringTasks.add(daytasks);
				i = j;
			}
		}

		return duringTasks;
	}
}
