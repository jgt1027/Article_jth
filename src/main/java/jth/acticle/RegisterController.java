package jth.acticle;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

	@Autowired
	ArticleDao articleDao;
	
	static final Logger logger = LogManager.getLogger();
	
	@GetMapping("/register/write")
	public void write() {
		logger.info("get write");
	}

	@PostMapping("/register/write")
	public String add(Article article) {
		articleDao.insert(article);
		logger.info("post write");
		return "list";
	}


	@RequestMapping(value="/register/read", method=RequestMethod.GET)
	public String read(@RequestParam int articleId,Model model) {
		Article read = articleDao.getArticle(articleId);
		model.addAttribute("read",read);
				return "/register/read";
		}

	@GetMapping("/list")
	public String list(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {
		final int COUNT = 100;
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", articleList);
		return "list";
	}
}