package com.ControleDeEstoque.section.DTO;

import java.io.Serializable;

import com.ControleDeEstoque.model.entity.section.Section;

public class SectionDTO implements Serializable {

	private Long idInventory;

	private int capacity;

	private Double busy;

	public SectionDTO() {
	}

	public SectionDTO(Long idInventory, int capacity, Double busy) {
		super();
		this.idInventory = idInventory;
		this.capacity = capacity;
		this.busy = busy;
	}

	public Section mappSection(SectionDTO sectionDTO) {
		return new Section(sectionDTO.getCapacity(), sectionDTO.getBusy());
	}

	public Long getIdInventory() {
		return idInventory;
	}

	public void setIdInventory(Long idInventory) {
		this.idInventory = idInventory;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Double getBusy() {
		return busy;
	}

	public void setBusy(Double busy) {
		this.busy = busy;
	}

}
