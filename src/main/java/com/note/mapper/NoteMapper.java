/**
 * 
 */
package com.note.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.note.entity.Note;

/**
 * @author Administrator
 * @created 2019年3月7日
 */
@Mapper
public interface NoteMapper {

	String TABLE = " note ";

	/**
	 * @description 通过ID查询note内容
	 * @param id
	 * @return
	 * @created 2019年3月7日
	 */
	@Select("select * from " + TABLE + " where id=#{id}")
	Note queryById(String id);

	/**
	 * @description 表中添加一条新的Note记录
	 * @param note
	 * @created 2019年3月7日
	 */
	@Insert("insert into " + TABLE + " (id,title,description,createDate,modifyDate) " //
			+ " values " //
			+ "(#{id},#{title},#{description},#{createDate},#{modifyDate})")
	void insert(Note note);

	/**
	 * @description clear all data
	 * 
	 * @created 2019年3月7日
	 */
	@Delete("truncate table " + TABLE)
	void clear();

	/**
	 * @description 查询全部记录
	 * @return
	 * @created 2019年3月24日
	 */
	@Select("select * from " + TABLE)
	List<Note> queryBy();

}
