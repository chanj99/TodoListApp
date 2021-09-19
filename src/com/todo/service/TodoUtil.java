package com.todo.service;

import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

/*
 * 모든 메소드들이 class 메소드로 모든 기능 구성. 별도의 객체를 안 만듬. 다 static 
 */
public class TodoUtil {
	
	/*
	 * 객체 하나 생성 하고 list에 넣는다. 
	 */
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목 추가]\n"  + "제목 > ");
		
		/*
		 * 	제목 중복 검사하고, 중복되면 추가 안 함. 
		 * */
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("(경고)제목이 중복되어 사용할 수 없습니다!");
			return;
		}
		/*
		 * 엔터를 한번 제거 해준다. 그래야 공백을 제거하고 내용을 정확하게 입력 가능. 
		 * */
		sc.nextLine();
		System.out.println("내용 > ");
		desc = sc.nextLine().trim(); //좌우여백 제거. 
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
		System.out.println("성공적으로 내용이 추가되었습니다! :) ");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("[항복 삭제]\n" + "삭제할 항복의 제목을 입력하세요 > ");
		String title = sc.next();
		/*
		 * 제목 일치하면 삭제!제목이 중복되는 것이 없어서 쉽게 삭제 가능. 
		 * */
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("성공적으로 내용이 삭제되었습니다! :) ");
				break;
			}
		}
	}

	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항복 수]n" + "수정할 항복의 제목을 입력하세요 > ");
		String title = sc.next().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("현재 입력하신 제목은 목록에 없는 제목입니다! :(");
			return;
		}
		
		/*
		 * if 문 통과. 목록에 있는 제목 입력받음. 
		 * */
		System.out.println("새로운 제목을 입력하세요 > ");
		String new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("중복되는 제목입니다. :(");
			return;
		}
		
		/*
		 * 원래 제목의 아이템을 찾아서, 해당 아이템을 지우고, 새로운 데이터를 입력함. 기존의 내용은 고치지 않고 지우고, 다시 넣는 메소드. 
		 * 시간도 자동으로 업데이트해서 들어감. 
		 * */
		System.out.println("새 내용은 입력하세요 > ");
		String new_description = sc.next().trim();
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				System.out.println("item updated");
			}
		}
	}

	public static void listAll(TodoList l) {
		System.out.println("[전체 목록]");
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
}
