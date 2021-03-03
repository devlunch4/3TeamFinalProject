package kr.or.ddit.farm.model;

public class GardenguidesVo {

	private String grdgd_code;
	private String writer;
	private String cls_code;
	private String grdgd_nm;
	private String difficulty;
	private String plant_prd;
	private String grow_prd;
	private String origin;
	private String temperature;
	private String damage;
	private String season;
	private String effect;
	private String ingredient;
	private String plant_tip;
	private String plant_content;
	private String file_nm;
	private String file_path;
	private String reg_dt;
	private String use;

	public GardenguidesVo() {
		super();
	}

	public GardenguidesVo(String grdgd_code, String writer, String cls_code, String grdgd_nm, String difficulty,
			String plant_prd, String grow_prd, String origin, String temperature, String damage, String season,
			String effect, String ingredient, String plant_tip, String plant_content, String file_nm, String file_path,
			String reg_dt, String use) {
		super();
		this.grdgd_code = grdgd_code;
		this.writer = writer;
		this.cls_code = cls_code;
		this.grdgd_nm = grdgd_nm;
		this.difficulty = difficulty;
		this.plant_prd = plant_prd;
		this.grow_prd = grow_prd;
		this.origin = origin;
		this.temperature = temperature;
		this.damage = damage;
		this.season = season;
		this.effect = effect;
		this.ingredient = ingredient;
		this.plant_tip = plant_tip;
		this.plant_content = plant_content;
		this.file_nm = file_nm;
		this.file_path = file_path;
		this.reg_dt = reg_dt;
		this.use = use;
	}

	public String getGrdgd_code() {
		return grdgd_code;
	}

	public void setGrdgd_code(String grdgd_code) {
		this.grdgd_code = grdgd_code;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCls_code() {
		return cls_code;
	}

	public void setCls_code(String cls_code) {
		this.cls_code = cls_code;
	}

	public String getGrdgd_nm() {
		return grdgd_nm;
	}

	public void setGrdgd_nm(String grdgd_nm) {
		this.grdgd_nm = grdgd_nm;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getPlant_prd() {
		return plant_prd;
	}

	public void setPlant_prd(String plant_prd) {
		this.plant_prd = plant_prd;
	}

	public String getGrow_prd() {
		return grow_prd;
	}

	public void setGrow_prd(String grow_prd) {
		this.grow_prd = grow_prd;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getPlant_tip() {
		return plant_tip;
	}

	public void setPlant_tip(String plant_tip) {
		this.plant_tip = plant_tip;
	}

	public String getPlant_content() {
		return plant_content;
	}

	public void setPlant_content(String plant_content) {
		this.plant_content = plant_content;
	}

	public String getFile_nm() {
		return file_nm;
	}

	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	@Override
	public String toString() {
		return "GardenguidesVo [grdgd_code=" + grdgd_code + ", writer=" + writer + ", cls_code=" + cls_code
				+ ", grdgd_nm=" + grdgd_nm + ", difficulty=" + difficulty + ", plant_prd=" + plant_prd + ", grow_prd="
				+ grow_prd + ", origin=" + origin + ", temperature=" + temperature + ", damage=" + damage + ", season="
				+ season + ", effect=" + effect + ", ingredient=" + ingredient + ", plant_tip=" + plant_tip
				+ ", plant_content=" + plant_content + ", file_nm=" + file_nm + ", file_path=" + file_path + ", reg_dt="
				+ reg_dt + ", use=" + use + "]";
	}

}