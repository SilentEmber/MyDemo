package com.note.service;

import java.util.List;

import com.note.entity.Note;

public interface NoteService {

	/**
	 * @description 通过id查询{@link Note}
	 * @param note
	 * @return
	 * @created 2019年3月7日
	 */
	Note queryById(String id);

	/**
	 * @description 新增一条{@link Note}记录
	 * @param note
	 * @return
	 * @created 2019年3月7日
	 */
	Note insert(Note note);

	/**
	 * @description 清空数据库
	 * 
	 * @created 2019年3月7日
	 */
	void clear();

	/**
	 * @description 查询全部数据
	 * @return
	 * @created 2019年3月24日
	 */
	List<Note> queryBy();

	/**
	 * @description 测试事务
	 * @return
	 * @created 2019年3月24日
	 */
	String test();

}
