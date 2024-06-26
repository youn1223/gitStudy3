package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myAlbumDao") //AlbumDao myAlbumDao = new AlbumDao();
public class AlbumDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate ;

	public AlbumDao() {
		System.out.println("AlbumDao()");
	}

	public List<AlbumBean> getAlbumList(Paging pageInfo, Map<String,String> map) {
		// whatColumn:singer,title
		// keyword:%·¹µå%, %»¡%
		System.out.println("offset:"+pageInfo.getOffset());
		System.out.println("limit:"+pageInfo.getLimit());
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList("album.AlbumBean.getAlbumList",map,rowBounds);
		System.out.println("lists.size():" + lists.size());
		//		select * from albums;
		return lists;
		//1 3 5 128
		//0 4 8 ?
		//2 2 2 2
	}//getAlbumList

	public int insertAlbum(AlbumBean album) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert("album.AlbumBean.insertAlbum",album);
		System.out.println("insertAlbum cnt:" + cnt);
		return cnt;
	}

	public AlbumBean getAlbum(int num) {
		AlbumBean album = null;
		album = sqlSessionTemplate.selectOne("album.AlbumBean.getAlbum",num);
		return album;
	}//getAlbum

	public int updateAlbum(AlbumBean album) {
		System.out.println("updateAlbum");
		System.out.println(album.getNum());
		System.out.println(album.getSinger());

		int cnt = -1;
		cnt = sqlSessionTemplate.update("album.AlbumBean.updateAlbum", album);
		System.out.println("updateAlbum cnt : " + cnt);
		return cnt;

	}//updateAlbum

	public int deleteAlbum(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete("album.AlbumBean.deleteAlbum", num);
		return cnt;
	}//deleteAlbum

	public int getTotalCount(Map<String, String> map){
		
		int count = -1;
		
		count = sqlSessionTemplate.selectOne("album.AlbumBean.getTotalCount", map);
		
		System.out.println("totalCount : " + count);
		
		return count;
	}										
}
