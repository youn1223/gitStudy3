package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {

	private final String command = "/insert.ab";
	private final String getPage = "albumInsertForm";
	private final String gotoPage = "redirect:/list.ab";
	
	@Autowired
	private AlbumDao albumDao;
	
	// albumList에서 추가하기 클릭했을 때
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	//albumInsertForm에서 추가하기 클릭했을 때 
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("album") @Valid AlbumBean album, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		int cnt = -1;
		cnt = albumDao.insertAlbum(album);
		mav.setViewName(gotoPage);
		return mav;
	}
}






