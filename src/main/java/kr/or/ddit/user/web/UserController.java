package kr.or.ddit.user.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.common.model.PageVoSearch;
import kr.or.ddit.fdata.service.FdataServiceImpl;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceImpl;

@RequestMapping("user")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// 필요한 스프링 빈 호출
	@Resource(name = "userService")
	private UserServiceImpl userService;
	
	@Resource(name = "fdataService")
	private FdataServiceImpl fdataService;

}