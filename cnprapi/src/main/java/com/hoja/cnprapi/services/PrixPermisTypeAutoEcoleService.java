package com.hoja.cnprapi.services;

import java.util.List;

import com.hoja.cnprapi.models.PrixTypePermisAutoEcole;


public interface PrixPermisTypeAutoEcoleService {

	public List<PrixTypePermisAutoEcole> getAllPrixTypePermisAutoEcole();

	public List<PrixTypePermisAutoEcole> getAllActivePrixTypePermisAutoEcole();

	public PrixTypePermisAutoEcole saveOrUpdatePrixTypePermisAutoEcole(PrixTypePermisAutoEcole pers);

	public boolean deletePrixTypePermisAutoEcoleById(long id);

	public void enableOrDisablePrixTypePermisAutoEcoleById(long id);

	public PrixTypePermisAutoEcole getPrixTypePermisAutoEcoleById(long id);
}
