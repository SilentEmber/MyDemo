package com.note.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.note.entity.Note;
import com.note.service.NoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = { "基于Note的简单操作" })
@RestController
@RequestMapping("/note")
public class NoteController {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(NoteController.class);

	@Autowired
	private NoteService noteService;

	@ApiOperation(value = "通过id查询Note信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "id", required = true, dataType = "String", paramType = "path"), //
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Note getNote(@PathVariable("id") String id) {
		logger.info(id);
		return noteService.queryById(id);
	}

	@ApiOperation(value = "插入新的Note")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "title", required = true, dataType = "String", paramType = "query", example = "title-test"), //
			@ApiImplicitParam(name = "description", required = true, dataType = "String", paramType = "query", example = "desc-test"), //
	})
	@PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void insertNote(@ApiIgnore Note note) {
		noteService.insert(note);
	}

	@ApiOperation(value = "清空全部数据!")
	@DeleteMapping(value = "/clear", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void clearNote() {
		noteService.clear();
	}

	@ApiOperation("查询全部数据")
	@GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Note> queryAllNotes() {
		return noteService.queryBy();
	}

	@ApiOperation("测试方法")
	@PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String test() {
		return noteService.test();
	}
}
