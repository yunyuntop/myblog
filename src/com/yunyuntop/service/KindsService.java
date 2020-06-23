package com.yunyuntop.service;

import java.util.List;

import com.yunyuntop.dao.KindsDao;
import com.yunyuntop.domain.Kinds;

public class KindsService {

	public void updateKind(Kinds kind){
		
new KindsDao().updateKind(kind);
	}
	public  Kinds findKindsById(String kid){
		
		return new KindsDao().findKindsById(kid);
	}
	public List<Kinds> findAllTag(){
		
		return new KindsDao().findAllTag();
	}
	public void delete(String kid) {
		 new KindsDao().delete(kid);
		
	}
	public Kinds addKinds(Kinds kind) {
		return new KindsDao().addKinds(kind);
		
	}
	public List<Kinds> findKindsText(String ktext) {
		
		return new KindsDao().findKindsText(ktext);
	}
	public Kinds findKindsByText(String k) {
		
		return new KindsDao().findKindsByText(k);
	}
}
