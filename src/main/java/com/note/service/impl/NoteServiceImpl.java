/**
 * 
 */
package com.note.service.impl;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.note.entity.Note;
import com.note.mapper.NoteMapper;
import com.note.service.NoteService;

/**
 * @author Administrator
 * @created 2019年3月7日
 */
@Service
public class NoteServiceImpl implements NoteService {
	// @SuppressWarnings("unused")
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(NoteServiceImpl.class);

	@Autowired
	private NoteMapper noteMapper;

	@Override
	public Note queryById(String id) {
		return noteMapper.queryById(id);
	}

	@Override
	// @Transactional(rollbackFor = RuntimeException.class)
	public Note insert(Note note) {
		try {
			Method thisMethod = NoteServiceImpl.class.getDeclaredMethod("insert", Note.class);
			Transactional[] tx = thisMethod.getDeclaredAnnotationsByType(Transactional.class);
			logger.info("内部方法有{}个Transactional注解信息.", String.valueOf(tx.length));
		} catch (NoSuchMethodException | SecurityException e) {
			logger.error(e.getMessage());
			logger.debug("", e);
		}
		Date date = new Date();
		String id = String.valueOf(date.getTime());
		note.setId(id);
		note.setModifyDate(date);
		note.setCreateDate(date);
		noteMapper.insert(note);
		throw new RuntimeException("内部抛出异常");
		// return note;
	}

	@Override
	public void clear() {
		noteMapper.clear();
	}

	@Override
	public List<Note> queryBy() {
		return noteMapper.queryBy();
	}

	@Override
	@Transactional(rollbackFor = RuntimeException.class)
	public String test() {
		try {
			Method thisMethod = NoteServiceImpl.class.getDeclaredMethod("test");
			Transactional[] tx = thisMethod.getDeclaredAnnotationsByType(Transactional.class);
			logger.info("外部方法有{}个Transactional注解信息.", String.valueOf(tx.length));
		} catch (NoSuchMethodException | SecurityException e) {
			logger.error(e.getMessage());
			logger.debug("", e);
		}
		Note note = new Note();
		Date date = new Date();
		note.setCreateDate(date);
		note.setModifyDate(date);
		note.setTitle("txTitle");
		note.setDescription("txTestDesc");
		note.setId(String.valueOf(date.getTime()));
		insert(note);
		return null;
	}

}
