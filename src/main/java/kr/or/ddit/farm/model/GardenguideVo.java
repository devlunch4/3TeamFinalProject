package kr.or.ddit.farm.model;

public class GardenguideVo {

	private String guide_code;
	private String writer;
	private String class_code;
	private String item_code;
	private String difficulty;
	private String grow_start_time;
	private String grow_time;
	private String origin;
	private String temperature;
	private String damage;
	private String season;
	private String effect;
	private String ingredient;
	private String plant_tip;
	private String plant_content;
	private String file_no;
	private String reg_dt;
	private String use_yn;

	public GardenguideVo() {
		super();
	}

	public GardenguideVo(String guide_code, String writer, String class_code, String item_code, String difficulty,
			String grow_start_time, String grow_time, String origin, String temperature, String damage, String season,
			String effect, String ingredient, String plant_tip, String plant_content, String file_no, String reg_dt,
			String use_yn) {
		super();
		this.guide_code = guide_code;
		this.writer = writer;
		this.class_code = class_code;
		this.item_code = item_code;
		this.difficulty = difficulty;
		this.grow_start_time = grow_start_time;
		this.grow_time = grow_time;
		this.origin = origin;
		this.temperature = temperature;
		this.damage = damage;
		this.season = season;
		this.effect = effect;
		this.ingredient = ingredient;
		this.plant_tip = plant_tip;
		this.plant_content = plant_content;
		this.file_no = file_no;
		this.reg_dt = reg_dt;
		this.use_yn = use_yn;
	}

	public String getGuide_code() {
		return guide_code;
	}

	public void setGuide_code(String guide_code) {
		this.guide_code = guide_code;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getClass_code() {
		return class_code;
	}

	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getGrow_start_time() {
		return grow_start_time;
	}

	public void setGrow_start_time(String grow_start_time) {
		this.grow_start_time = grow_start_time;
	}

	public String getGrow_time() {
		return grow_time;
	}

	public void setGrow_time(String grow_time) {
		this.grow_time = grow_time;
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

	public String getFile_no() {
		return file_no;
	}

	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	@Override
	public String toString() {
		return "GardenguideVo [guide_code=" + guide_code + ", writer=" + writer + ", class_code=" + class_code
				+ ", item_code=" + item_code + ", difficulty=" + difficulty + ", grow_start_time=" + grow_start_time
				+ ", grow_time=" + grow_time + ", origin=" + origin + ", temperature=" + temperature + ", damage="
				+ damage + ", season=" + season + ", effect=" + effect + ", ingredient=" + ingredient + ", plant_tip="
				+ plant_tip + ", plant_content=" + plant_content + ", file_no=" + file_no + ", reg_dt=" + reg_dt
				+ ", use_yn=" + use_yn + "]";
	}

}