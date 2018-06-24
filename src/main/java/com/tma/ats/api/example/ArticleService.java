package com.tma.ats.api.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.db.dao.FleetDao;
import com.tma.ats.api.db.entity.Fleet;
import com.tma.ats.api.dto.FleetObject;
import com.tma.ats.api.service.FleetService;
@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDAO articleDAO;
	
	@Autowired
	private FleetService fleetService;
	
	@Override
	public Article getArticleById(int articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
		List<FleetObject> fleets = fleetService.getAllFleets();
		if (fleets != null) {
			for(FleetObject fleet : fleets) {
				System.out.println(fleet.getName());
			}
		}
		return articleDAO.getAllArticles();
	}
	@Override
	public synchronized boolean addArticle(Article article){
       if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
    	   return false;
       } else {
    	   articleDAO.addArticle(article);
    	   return true;
       }
	}
	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}
	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
}
