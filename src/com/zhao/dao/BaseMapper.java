package com.zhao.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 基础类：各实现类的父类 (Mybatis)
 * @author 赵翔
 * @lastModify 2016/10/12 11:10
 * @version 
 */
public class BaseMapper<T> {
	
    private static SqlSessionFactory sf;
    
    private SqlSession sqlsession;
    
    static{
    	InputStream in=null;
    	try {
			in=Resources.getResourceAsStream("com/config/Mybatis.xml");
			sf=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 提供给子类的获取一个SqlSession对象的方法
     */
    public SqlSession openSession(){
    	sqlsession=sf.openSession();
    	return sqlsession;
    }
    
	
//	public SqlSession getSession(){
//		return sf.openSession();
//	}
//	
//	/**
//	 * 新增
//	 * @param t
//	 * @return
//	 */
//	public void save(String namespace,T t){
//		sqlsession=sf.openSession();
//		sqlsession.insert(namespace, t);
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	
//	/**
//	 * 修改
//	 * @param t
//	 * @return
//	 */
//	public T Update(String namespace,T t){
//		sqlsession=sf.openSession();
//		sqlsession.delete(namespace, t);
//		sqlsession.commit();
//		sqlsession.close();
//		return t;
//	}
//	
//	/**
//	 * 删除
//	 * @param t
//	 * @return
//	 */
//	public void delete(String namespace,int id){
//		sqlsession=sf.openSession();
//		sqlsession.update(namespace, id);
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	
//	/**
//	 * 查询一个对象
//	 * @param id
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public T selectOne(String namespace,Object param){
//		sqlsession=sf.openSession();
//		T t=(T)sqlsession.selectOne(namespace,param);
//		sqlsession.close();
//		return t;
//	}
//	
//	/**
//	 * 查询
//	 * @param namespaceAndStatementid
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public List<T> selectList(String namespaceAndStatementid,Object param){
//		sqlsession = sf.openSession();
//		List<T> list = (List<T>)sqlsession.selectList(namespaceAndStatementid,param);
//		sqlsession.commit();
//		sqlsession.close();
//		return list;
//	}
//	
	
	
	
}
