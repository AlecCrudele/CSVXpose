
public class SpecSheetMapper {
	public void updateMappings() {
		SpecSheetIO packager = new SpecSheetIO();
		
	//Hospital Based Units Start -->
		
		// Hospital Based Units | Home Health Statistics | (hbu.hhs) -> Home Health Visits (DBNAME : hhs_hhv)
				SpecSheet homeHealthVisits = new SpecSheet("hbu.hhs", "home_health_visits");
				homeHealthVisits.addRecord(new RowRecord("S410000", "02100", "00500", "skilled_nursing_visit", false), 1);
				homeHealthVisits.addRecord(new RowRecord("S410000", "02300", "00500", "physical_therapy_visit", false), 2);
				homeHealthVisits.addRecord(new RowRecord("S410000", "02500", "00500", "occ_therapy_visit", false), 3);
				homeHealthVisits.addRecord(new RowRecord("S410000", "02700", "00500", "speech_path_visit", false), 4);
				homeHealthVisits.addRecord(new RowRecord("S410000", "02900", "00500", "medical_soc_serv_visit", false), 5);
				homeHealthVisits.addRecord(new RowRecord("S410000", "03100", "00500", "home_health_aide_visit", false), 6);
				homeHealthVisits.addRecord(new RowRecord("S410000", "03300", "00500", "total_visit", false), 7);
				homeHealthVisits.addRecord(new RowRecord("S410000", "01900", "00100", "num_cbsa_hha", false), 8);
				packager.save(homeHealthVisits, homeHealthVisits.getSheetSection() + "." + homeHealthVisits.getSheetName());
				
		// Hospital Based Units | Home Health Statistics | (hbu.hhs) -> Medicare Cost Per Visit by Type (DBNAME : hhs_mcpv)
				SpecSheet mcpv = new SpecSheet("hbu.hhs", "medicare_cost_per_visit_type");
				mcpv.addRecord(new RowRecord("H310181", "00100", "00500", "skilled_nursing", false), 1);
				mcpv.addRecord(new RowRecord("H310181", "00200", "00500", "physical_therapy", false), 2);
				mcpv.addRecord(new RowRecord("H310181", "00300", "00500", "occ_therapy", false), 3);
				mcpv.addRecord(new RowRecord("H310181", "00400", "00500", "speech_path", false), 4);
				mcpv.addRecord(new RowRecord("H310181", "00500", "00500", "medical_soc_serv", false), 5);
				mcpv.addRecord(new RowRecord("H310181", "00600", "00500", "home_health_aide", false), 6);
				mcpv.addRecord(new RowRecord("H310181", "00700", "00500", "total_cost", true, "total", new int[]{1, 2, 3, 4, 5, 6}), 7);
				packager.save(mcpv, mcpv.getSheetSection() + "." + mcpv.getSheetName());
				
		// Hospital Based Units | Home Health Statistics | (hbu.hhs) -> Medicare Reimbursement Earned (Net) (DBNAME : hhs_mre)
				SpecSheet mre = new SpecSheet("hbu.hhs", "medicare_reimbursement_earned");
				mre.addRecord(new RowRecord("H410182", "03100", "00100", "parta_reimb_net", false), 1);
				mre.addRecord(new RowRecord("H410182", "03101", "00100", "parta_seq", false), 2);
				mre.addRecord(new RowRecord("H410182", "03100", "00200", "partb_reimb_net", false), 3);
				mre.addRecord(new RowRecord("H410182", "03101", "00200", "partb_seq", false), 4);
				packager.save(mre, mre.getSheetSection() + "." + mre.getSheetName());
				
		// Hospital Based Units | Hospice | (hbu.hspce) -> Hospice (DBNAME : hbu_hspce)
				SpecSheet hbu_hspce = new SpecSheet("hbu.hhs", "hospice");
				hbu_hspce.addRecord(new RowRecord("S910000", "00100", "00600", "hcd_cont_home_care", false), 1);
				hbu_hspce.addRecord(new RowRecord("S910000", "00200", "00600", "hcd_rout_home_care", false), 2);
				hbu_hspce.addRecord(new RowRecord("S910000", "00300", "00600", "hcd_inp_resp_care", false), 3);
				hbu_hspce.addRecord(new RowRecord("S910000", "00400", "00600", "hcd_gen_inp_care", false), 4);
				hbu_hspce.addRecord(new RowRecord("S910000", "00500", "00600", "hcd_tot_days", false), 5);
				hbu_hspce.addRecord(new RowRecord("S910000", "00600", "00600", "num_rec_hospice_care", false), 6);
				hbu_hspce.addRecord(new RowRecord("S910000", "00800", "00100", "alos_t8", false), 7);
				hbu_hspce.addRecord(new RowRecord("S910000", "00800", "00200", "alos_t9", false), 8);
				hbu_hspce.addRecord(new RowRecord("S910000", "00800", "00300", "alos_t8_nurs", false), 9);
				hbu_hspce.addRecord(new RowRecord("S910000", "00800", "00400", "alos_t9_nurs", false), 10);
				hbu_hspce.addRecord(new RowRecord("S910000", "00800", "00500", "alos_all_other", false), 11);
				hbu_hspce.addRecord(new RowRecord("S910000", "00800", "00600", "alos_total", true, "total", new int[]{7, 8, 11}), 12);
				hbu_hspce.addRecord(new RowRecord("S910000", "00900", "00100", "uc_t8", false), 13);
				hbu_hspce.addRecord(new RowRecord("S910000", "00900", "00200", "uc_t9", false), 14);
				hbu_hspce.addRecord(new RowRecord("S910000", "00900", "00300", "uc_t8_nurs", false), 15);
				hbu_hspce.addRecord(new RowRecord("S910000", "00900", "00400", "uc_t9_nurs", false), 16);
				hbu_hspce.addRecord(new RowRecord("S910000", "00900", "00500", "uc_all_other", false), 17);
				hbu_hspce.addRecord(new RowRecord("S910000", "00900", "00600", "uc_total", false), 18);
				hbu_hspce.addRecord(new RowRecord("K610000", "00300", "00400", "avg_per_diem", false), 19);
				packager.save(hbu_hspce, hbu_hspce.getSheetSection() + "." + hbu_hspce.getSheetName());
				
		// Hospital Based Units | Inpatient Psychiatric Facility | (hbu.ipf) -> Inpatient Psychiatric Facility (DBNAME : hbu_ipf)
				SpecSheet hbu_ipf = new SpecSheet("hbu.ipf", "inpatient_psych_facility");
				hbu_ipf.addRecord(new RowRecord(false, "S200001", "07000", "00100", "is_ipf", false), 1);
				hbu_ipf.addRecord(new RowRecord("S300001", "01400", "00800", "ipf_hosp_pday", false), 2);
				hbu_ipf.addRecord(new RowRecord("S300001", "01600", "00800", "ipf_sub_pday", false), 3);
				hbu_ipf.addRecord(new RowRecord("S300001", "01400", "01500", "ipf_hosp_disc", false), 4);
				hbu_ipf.addRecord(new RowRecord("S300001", "01600", "01500", "ipf_sub_disc", false), 5);
				hbu_ipf.addRecord(new RowRecord("S300001", "01400", "00600", "ipf_hosp_med_pday", false), 6);
				hbu_ipf.addRecord(new RowRecord("S300001", "01600", "00600", "ipf_sub_med_pday", false), 7);
				hbu_ipf.addRecord(new RowRecord("E30A182", "01200", "00100", "ipf_hosp_med_reimb", false), 8);
				packager.save(hbu_ipf, hbu_ipf.getSheetSection() + "." + hbu_ipf.getSheetName());
				
		// Hospital Based Units | Inpatient Rehab Facility | (hbu.irf) -> Inpatient Rehab Facility (DBNAME : hbu_irf)
				SpecSheet hbu_irf = new SpecSheet("hbu.irf", "inpatient_rehab_facility");
				hbu_irf.addRecord(new RowRecord(false, "S200001", "07500", "00100", "is_irf", false), 1);
				hbu_irf.addRecord(new RowRecord("S300001", "01400", "00800", "irf_hosp_pday", false), 2);
				hbu_irf.addRecord(new RowRecord("S300001", "01700", "00800", "irf_sub_pday", false), 3);
				hbu_irf.addRecord(new RowRecord("S300001", "01400", "01500", "irf_hosp_disc", false), 4);
				hbu_irf.addRecord(new RowRecord("S300001", "01700", "01500", "irf_sub_disc", false), 5);
				hbu_irf.addRecord(new RowRecord("S300001", "01400", "00600", "irf_hosp_med_pday", false), 6);
				hbu_irf.addRecord(new RowRecord("S300001", "01700", "00600", "irf_sub_med_pday", false), 7);
				hbu_irf.addRecord(new RowRecord("E30A182", "01300", "00100", "irf_hosp_med_reimb", false), 8);
				packager.save(hbu_irf, hbu_irf.getSheetSection() + "." + hbu_irf.getSheetName());
				
		// Hospital Based Units | Skilled Nursing Facility | (hbu.snf) -> Skilled Nursing Facility (DBNAME : hbu_snf)
				SpecSheet hbu_snf = new SpecSheet("hbu.snf", "skilled_nursing_facility");
				hbu_snf.addRecord(new RowRecord(false, "S200001", "07567", "00100", "is_nf", false), 1);
				hbu_snf.addRecord(new RowRecord("S300001", "01900", "00200", "snf_beds", false), 2);
				hbu_snf.addRecord(new RowRecord("S300001", "02000", "00200", "nf_beds", false), 3);
				hbu_snf.addRecord(new RowRecord("S300001", "01900", "00800", "snf_days", false), 4);
				hbu_snf.addRecord(new RowRecord("S300001", "02000", "00800", "nf_days", false), 5);
				hbu_snf.addRecord(new RowRecord("S300001", "01900", "00300", "snf_bda", false), 6);
				hbu_snf.addRecord(new RowRecord("S300001", "02000", "00300", "nf_bda", false), 7);
				hbu_snf.addRecord(new RowRecord("E30E186", "01500", "00100", "net_reimb_before_seq", false), 8);
				hbu_snf.addRecord(new RowRecord("E30E186", "01501", "00100", "seq", false), 9);
				packager.save(hbu_snf, hbu_snf.getSheetSection() + "." + hbu_snf.getSheetName());
				
	//Hospital Based Units End --!>
				

	// Hospital Core Start -->

		// Hospital Core | Average Hourly Rate | (hc.al.rate) -> Average Hourly Rate (DBNAME: al_rate)
		SpecSheet avgHourlyRate = new SpecSheet("hc.al", "avg_hourly_rate");
		avgHourlyRate.addRecord(new RowRecord("S300003", "00300", "00600", "salaries"), 1);
		avgHourlyRate.addRecord(new RowRecord("S300003", "00400", "00600", "other_wage_rel_cost"), 2);
		avgHourlyRate.addRecord(new RowRecord("S300003", "00600", "00600", "total"), 3);
		avgHourlyRate.addRecord(new RowRecord("S300003", "00700", "00600", "overhead"), 4);
		packager.save(avgHourlyRate, avgHourlyRate.getSheetSection() + "." + avgHourlyRate.getSheetName());

		// Hospital Core | Contract Labor | (hc.al.cl) -> Contract Labor (DBNAME: al_cl)
		SpecSheet contractLabor = new SpecSheet("hc.al", "contract_labor");
		//Physician Wage/Hours/Rate
		contractLabor.addRecord(new RowRecord("S300002", "01300", "00400", "phys_wage"), 1);
		contractLabor.addRecord(new RowRecord("S300002", "01300", "00500", "phys_hours"), 2);
		contractLabor.addRecord(new RowRecord("S300002", "01300", "00600", "phys_rate"), 3);
		//Management Wage/Hours/Rate
		contractLabor.addRecord(new RowRecord("S300002", "01200", "00400", "mng_wage"), 4);
		contractLabor.addRecord(new RowRecord("S300002", "01200", "00500", "mng_hours"), 5);
		contractLabor.addRecord(new RowRecord("S300002", "01200", "00600", "mng_rate"), 6);
		//Direct Patient Care Wage/Hours/Rate
		contractLabor.addRecord(new RowRecord("S300002", "01100", "00400", "dpc_wage"), 7);
		contractLabor.addRecord(new RowRecord("S300002", "01100", "00500", "dpc_hours"), 8);
		contractLabor.addRecord(new RowRecord("S300002", "01100", "00600", "dpc_rate"), 9);
		//Total Labor Expenses
		contractLabor.addRecord(new RowRecord("A000000", "20000", "00100", "total_labor_expenses"), 10);
		packager.save(contractLabor, contractLabor.getSheetSection() + "." + contractLabor.getSheetName());
		
		// Hospital Core | FTE Counts | (hc.al.fte) -> FTE Counts (DBNAME: al_fte)
		SpecSheet fte_count = new SpecSheet("hc.al", "fte_count");
		fte_count.addRecord(new RowRecord("S300001", "01400", "01000", "acute_care"), 1);
		fte_count.addRecord(new RowRecord("S300001", "02700", "01000", "total_overall"), 2);
		packager.save(fte_count, fte_count.getSheetSection() + "." + fte_count.getSheetName());

		// Hospital Core | Available Beds | (hc.lic_beds) -> Licensed Beds (DBNAME: lic_beds)
		SpecSheet availableBeds = new SpecSheet("hc", "lic_beds");
		availableBeds.addRecord(new RowRecord("S300001", "00700", "00200", "adults_and_peds", true, "subrow"), 1);
		availableBeds.addRecord(new RowRecord("S300001", "00800", "00200", "intensive_care_unit", true, "subrow"), 2);
		availableBeds.addRecord(new RowRecord("S300001", "00900", "00200", "coronary_care_unit", true, "subrow"), 3);
		availableBeds.addRecord(new RowRecord("S300001", "01000", "00200", "burn_intensive_care_unit", true, "subrow"), 4);
		availableBeds.addRecord(new RowRecord("S300001", "01100", "00200", "surgical_intensive_care_unit", true, "subrow"), 5);
		availableBeds.addRecord(new RowRecord("S300001", "01200", "00200", "other_special_care", true, "subrow"), 6);
		availableBeds.addRecord(new RowRecord("S300001", "01300", "00200", "nursery", true, "subrow"), 7);
		availableBeds.addRecord(new RowRecord("S300001", "02400", "00200", "hospice", true, "subrow"), 8);
		availableBeds.addRecord(new RowRecord("S300001", "02700", "00200", "total", true, "subrow"), 9);
		packager.save(availableBeds, availableBeds.getSheetSection() + "." + availableBeds.getSheetName());
		
		// Hospital Core | Analysis of Changes in Total Capital Asset Balances | (hc.actcab) -> ACTCAB (DBNAME: capex_actcab)
		SpecSheet actcab = new SpecSheet("hc", "capex_actcab");
		actcab.addRecord(new RowRecord("A700002", "01000", "00100", "actcab_begin_bal", false), 1);
		actcab.addRecord(new RowRecord("A700002", "01000", "00200", "actcab_purchases", false), 2);
		actcab.addRecord(new RowRecord("A700002", "01000", "00300", "actcab_donations", false), 3);
		actcab.addRecord(new RowRecord("A700002", "01000", "00400", "actcab_total_pd", false), 4);
		actcab.addRecord(new RowRecord("A700002", "01000", "00500", "actcab_disp_retire", false), 5);
		actcab.addRecord(new RowRecord("A700002", "01000", "00600", "actcab_end_bal", false), 6);
		actcab.addRecord(new RowRecord("A700002", "01000", "00700", "actcab_fully_dep_assets", false), 7);
		packager.save(actcab, actcab.getSheetSection() + "." + actcab.getSheetName());
		
		// Hospital Core | Capital Related Costs | (hc.crc) -> Capital Related Costs (DBNAME: capex_crc)
		SpecSheet cap_rel_cost = new SpecSheet("hc", "capex_crc");
		cap_rel_cost.addRecord(new RowRecord("A700002", "00300", "00900", "crc_depreciation", false), 1);
		cap_rel_cost.addRecord(new RowRecord("A700002", "00300", "01000", "crc_lease", false), 2);
		cap_rel_cost.addRecord(new RowRecord("A700002", "00300", "01100", "crc_interest", false), 3);
		cap_rel_cost.addRecord(new RowRecord("A700002", "00300", "01200", "crc_insurance", false), 4);
		cap_rel_cost.addRecord(new RowRecord("A700002", "00300", "01300", "crc_taxes", false), 5);
		cap_rel_cost.addRecord(new RowRecord("A700002", "00300", "01400", "crc_other_cap_rel_costs", false), 6);
		cap_rel_cost.addRecord(new RowRecord("A700002", "00300", "01500", "crc_total", false), 7);
		packager.save(cap_rel_cost, cap_rel_cost.getSheetSection() + "." + cap_rel_cost.getSheetName());
		
		// Hospital Core | Detail of Capital Asset Additions | (hc.dcaa) -> Detail of Capital Asset Additions (DBNAME: capex_dcaa)
		SpecSheet dcaa = new SpecSheet("hc", "capex_dcaa");
		dcaa.addRecord(new RowRecord("A700001", "00100", "00300", "dcaa_do_land", false), 1);
		dcaa.addRecord(new RowRecord("A700001", "00200", "00300", "dcaa_do_land_imp", false), 2);
		dcaa.addRecord(new RowRecord("A700001", "00300", "00300", "dcaa_do_build_fix", false), 3);
		dcaa.addRecord(new RowRecord("A700001", "00400", "00300", "dcaa_do_build_imp", false), 4);
		dcaa.addRecord(new RowRecord("A700001", "00500", "00300", "dcaa_do_fixed_equip", false), 5);
		dcaa.addRecord(new RowRecord("A700001", "00600", "00300", "dcaa_do_move_equip", false), 6);
		dcaa.addRecord(new RowRecord("A700001", "00700", "00300", "dcaa_do_hit_assets", false), 7);
		dcaa.addRecord(new RowRecord("A700001", "00900", "00300", "dcaa_do_other_rec_items", false), 8);
		dcaa.addRecord(new RowRecord("A700001", "01000", "00300", "dcaa_do_tot_additions", false), 9);
		dcaa.addRecord(new RowRecord("A700001", "00100", "00200", "dcaa_po_land", false), 10);
		dcaa.addRecord(new RowRecord("A700001", "00200", "00200", "dcaa_po_land_imp", false), 11);
		dcaa.addRecord(new RowRecord("A700001", "00300", "00200", "dcaa_po_build_fix", false), 12);
		dcaa.addRecord(new RowRecord("A700001", "00400", "00200", "dcaa_po_build_imp", false), 13);
		dcaa.addRecord(new RowRecord("A700001", "00500", "00200", "dcaa_po_fixed_equip", false), 14);
		dcaa.addRecord(new RowRecord("A700001", "00600", "00200", "dcaa_po_move_equip", false), 15);
		dcaa.addRecord(new RowRecord("A700001", "00700", "00200", "dcaa_po_hit_assets", false), 16);
		dcaa.addRecord(new RowRecord("A700001", "00900", "00200", "dcaa_po_other_rec_items", false), 17);
		dcaa.addRecord(new RowRecord("A700001", "01000", "00200", "dcaa_po_tot_additions", false), 18);
		dcaa.addRecord(new RowRecord("A700001", "00100", "00400", "dcaa_pd_land", false), 19);
		dcaa.addRecord(new RowRecord("A700001", "00200", "00400", "dcaa_pd_land_imp", false), 20);
		dcaa.addRecord(new RowRecord("A700001", "00300", "00400", "dcaa_pd_build_fix", false), 21);
		dcaa.addRecord(new RowRecord("A700001", "00400", "00400", "dcaa_pd_build_imp", false), 22);
		dcaa.addRecord(new RowRecord("A700001", "00500", "00400", "dcaa_pd_fixed_equip", false), 23);
		dcaa.addRecord(new RowRecord("A700001", "00600", "00400", "dcaa_pd_move_equip", false), 24);
		dcaa.addRecord(new RowRecord("A700001", "00700", "00400", "dcaa_pd_hit_assets", false), 25);
		dcaa.addRecord(new RowRecord("A700001", "00900", "00400", "dcaa_pd_other_rec_items", false), 26);
		dcaa.addRecord(new RowRecord("A700001", "01000", "00400", "dcaa_pd_tot_additions", false), 27);
		packager.save(dcaa, dcaa.getSheetSection() + "." + dcaa.getSheetName());
		
		// Hospital Core | Expense Analytics | (hc.ea) -> Cost Center Distribution - Other Expenses (DBNAME: ccd_other)
		SpecSheet ccd_other = new SpecSheet("hc", "ccd_other");
		ccd_other.addRecord(new RowRecord("A000000", "00400", "00200", "emp_benefits_dep", true), 1);
		ccd_other.addRecord(new RowRecord("A000000", "00500", "00200", "admin_and_gen", true), 2);
		ccd_other.addRecord(new RowRecord("A000000", "00600", "00200", "main_and_repairs", true), 3);
		ccd_other.addRecord(new RowRecord("A000000", "00700", "00200", "op_of_plant", true), 4);
		ccd_other.addRecord(new RowRecord("A000000", "00800", "00200", "laundry_and_linen", true), 5);
		ccd_other.addRecord(new RowRecord("A000000", "00900", "00200", "housekeeping", true), 6);
		ccd_other.addRecord(new RowRecord("A000000", "01000", "00200", "dietary", true), 7);
		ccd_other.addRecord(new RowRecord("A000000", "01100", "00200", "cafeteria", true), 8);
		ccd_other.addRecord(new RowRecord("A000000", "01200", "00200", "main_of_personnel", true), 9);
		ccd_other.addRecord(new RowRecord("A000000", "01300", "00200", "nursing_admin", true), 10);
		ccd_other.addRecord(new RowRecord("A000000", "01400", "00200", "central_serv_and_sup", true), 11);
		ccd_other.addRecord(new RowRecord("A000000", "01500", "00200", "pharmacy", true), 12);
		ccd_other.addRecord(new RowRecord("A000000", "01600", "00200", "med_rec_and_lib", true), 13);
		ccd_other.addRecord(new RowRecord("A000000", "01700", "00200", "soc_serv", true), 14);
		ccd_other.addRecord(new RowRecord("A000000", "03000", "00200", "adult_and_ped", true), 15);
		ccd_other.addRecord(new RowRecord("A000000", "03100", "00200", "icu", true), 16);
		ccd_other.addRecord(new RowRecord("A000000", "03200", "00200", "ccu", true), 17);
		ccd_other.addRecord(new RowRecord("A000000", "03300", "00200", "bicu", true), 18);
		ccd_other.addRecord(new RowRecord("A000000", "03400", "00200", "sicu", true), 19);
		ccd_other.addRecord(new RowRecord("A000000", "05000", "00200", "op_room", true), 20);
		ccd_other.addRecord(new RowRecord("A000000", "05100", "00200", "recov_room", true), 21);
		ccd_other.addRecord(new RowRecord("A000000", "05200", "00200", "labor_delivery_room", true), 22);
		ccd_other.addRecord(new RowRecord("A000000", "05300", "00200", "anesthesiology", true), 23);
		ccd_other.addRecord(new RowRecord("A000000", "05400", "00200", "radiology_diag", true), 24);
		ccd_other.addRecord(new RowRecord("A000000", "05500", "00200", "radiology_therap", true), 25);
		ccd_other.addRecord(new RowRecord("A000000", "05600", "00200", "radioisotope", true), 26);
		ccd_other.addRecord(new RowRecord("A000000", "05700", "00200", "ct_scan", true), 27);
		ccd_other.addRecord(new RowRecord("A000000", "05800", "00200", "mri", true), 28);
		ccd_other.addRecord(new RowRecord("A000000", "05900", "00200", "cardiac_cath", true), 29);
		ccd_other.addRecord(new RowRecord("A000000", "06000", "00200", "laboratory", true), 30);
		ccd_other.addRecord(new RowRecord("A000000", "06100", "00200", "pbp_clinical", true), 31);
		ccd_other.addRecord(new RowRecord("A000000", "06200", "00200", "blood_cells", true), 32);
		ccd_other.addRecord(new RowRecord("A000000", "06300", "00200", "blood_store_proc_trans", true), 33);
		ccd_other.addRecord(new RowRecord("A000000", "06400", "00200", "iv_therap", true), 34);
		ccd_other.addRecord(new RowRecord("A000000", "06500", "00200", "resp_therap", true), 35);
		ccd_other.addRecord(new RowRecord("A000000", "06600", "00200", "phys_therap", true), 36);
		ccd_other.addRecord(new RowRecord("A000000", "06700", "00200", "occup_therap", true), 37);
		ccd_other.addRecord(new RowRecord("A000000", "06800", "00200", "speech_path", true), 38);
		ccd_other.addRecord(new RowRecord("A000000", "06900", "00200", "electrocardio", true), 39);
		ccd_other.addRecord(new RowRecord("A000000", "07000", "00200", "electroenceph", true), 40);
		ccd_other.addRecord(new RowRecord("A000000", "07100", "00200", "med_sup_chrg_to_pat", true), 41);
		ccd_other.addRecord(new RowRecord("A000000", "07200", "00200", "implant_dev_chrg_to_pat", true), 42);
		ccd_other.addRecord(new RowRecord("A000000", "07300", "00200", "drugs_chrg_to_pat", true), 43);
		ccd_other.addRecord(new RowRecord("A000000", "07400", "00200", "renal_dialysis", true), 44);
		ccd_other.addRecord(new RowRecord("A000000", "09100", "00200", "emergency", true), 45);
		ccd_other.addRecord(new RowRecord("A000000", "11800", "00200", "subtotal", true), 46);
		ccd_other.addRecord(new RowRecord("A000000", "20000", "00200", "total", true), 47);
		packager.save(ccd_other, ccd_other.getSheetSection() + "." + ccd_other.getSheetName());
		
		// Hospital Core | Expense Analytics | (hc.ea) -> Cost Center Distribution - Labor Expenses (DBNAME: ccd_salary)
				SpecSheet ccd_salary = new SpecSheet("hc", "ccd_salary");
				ccd_salary.addRecord(new RowRecord("A000000", "00400", "00100", "emp_benefits_dep", true), 1);
				ccd_salary.addRecord(new RowRecord("A000000", "00500", "00100", "admin_and_gen", true), 2);
				ccd_salary.addRecord(new RowRecord("A000000", "00600", "00100", "main_and_repairs", true), 3);
				ccd_salary.addRecord(new RowRecord("A000000", "00700", "00100", "op_of_plant", true), 4);
				ccd_salary.addRecord(new RowRecord("A000000", "00800", "00100", "laundry_and_linen", true), 5);
				ccd_salary.addRecord(new RowRecord("A000000", "00900", "00100", "housekeeping", true), 6);
				ccd_salary.addRecord(new RowRecord("A000000", "01000", "00100", "dietary", true), 7);
				ccd_salary.addRecord(new RowRecord("A000000", "01100", "00100", "cafeteria", true), 8);
				ccd_salary.addRecord(new RowRecord("A000000", "01200", "00100", "main_of_personnel", true), 9);
				ccd_salary.addRecord(new RowRecord("A000000", "01300", "00100", "nursing_admin", true), 10);
				ccd_salary.addRecord(new RowRecord("A000000", "01400", "00100", "central_serv_and_sup", true), 11);
				ccd_salary.addRecord(new RowRecord("A000000", "01500", "00100", "pharmacy", true), 12);
				ccd_salary.addRecord(new RowRecord("A000000", "01600", "00100", "med_rec_and_lib", true), 13);
				ccd_salary.addRecord(new RowRecord("A000000", "01700", "00100", "soc_serv", true), 14);
				ccd_salary.addRecord(new RowRecord("A000000", "03000", "00100", "adult_and_ped", true), 15);
				ccd_salary.addRecord(new RowRecord("A000000", "03100", "00100", "icu", true), 16);
				ccd_salary.addRecord(new RowRecord("A000000", "03200", "00100", "ccu", true), 17);
				ccd_salary.addRecord(new RowRecord("A000000", "03300", "00100", "bicu", true), 18);
				ccd_salary.addRecord(new RowRecord("A000000", "03400", "00100", "sicu", true), 19);
				ccd_salary.addRecord(new RowRecord("A000000", "05000", "00100", "op_room", true), 20);
				ccd_salary.addRecord(new RowRecord("A000000", "05100", "00100", "recov_room", true), 21);
				ccd_salary.addRecord(new RowRecord("A000000", "05200", "00100", "labor_delivery_room", true), 22);
				ccd_salary.addRecord(new RowRecord("A000000", "05300", "00100", "anesthesiology", true), 23);
				ccd_salary.addRecord(new RowRecord("A000000", "05400", "00100", "radiology_diag", true), 24);
				ccd_salary.addRecord(new RowRecord("A000000", "05500", "00100", "radiology_therap", true), 25);
				ccd_salary.addRecord(new RowRecord("A000000", "05600", "00100", "radioisotope", true), 26);
				ccd_salary.addRecord(new RowRecord("A000000", "05700", "00100", "ct_scan", true), 27);
				ccd_salary.addRecord(new RowRecord("A000000", "05800", "00100", "mri", true), 28);
				ccd_salary.addRecord(new RowRecord("A000000", "05900", "00100", "cardiac_cath", true), 29);
				ccd_salary.addRecord(new RowRecord("A000000", "06000", "00100", "laboratory", true), 30);
				ccd_salary.addRecord(new RowRecord("A000000", "06100", "00100", "pbp_clinical", true), 31);
				ccd_salary.addRecord(new RowRecord("A000000", "06200", "00100", "blood_cells", true), 32);
				ccd_salary.addRecord(new RowRecord("A000000", "06300", "00100", "blood_store_proc_trans", true), 33);
				ccd_salary.addRecord(new RowRecord("A000000", "06400", "00100", "iv_therap", true), 34);
				ccd_salary.addRecord(new RowRecord("A000000", "06500", "00100", "resp_therap", true), 35);
				ccd_salary.addRecord(new RowRecord("A000000", "06600", "00100", "phys_therap", true), 36);
				ccd_salary.addRecord(new RowRecord("A000000", "06700", "00100", "occup_therap", true), 37);
				ccd_salary.addRecord(new RowRecord("A000000", "06800", "00100", "speech_path", true), 38);
				ccd_salary.addRecord(new RowRecord("A000000", "06900", "00100", "electrocardio", true), 39);
				ccd_salary.addRecord(new RowRecord("A000000", "07000", "00100", "electroenceph", true), 40);
				ccd_salary.addRecord(new RowRecord("A000000", "07100", "00100", "med_sup_chrg_to_pat", true), 41);
				ccd_salary.addRecord(new RowRecord("A000000", "07200", "00100", "implant_dev_chrg_to_pat", true), 42);
				ccd_salary.addRecord(new RowRecord("A000000", "07300", "00100", "drugs_chrg_to_pat", true), 43);
				ccd_salary.addRecord(new RowRecord("A000000", "07400", "00100", "renal_dialysis", true), 44);
				ccd_salary.addRecord(new RowRecord("A000000", "09100", "00100", "emergency", true), 45);
				ccd_salary.addRecord(new RowRecord("A000000", "11800", "00100", "subtotal", true), 46);
				ccd_salary.addRecord(new RowRecord("A000000", "20000", "00100", "total", true), 47);
				packager.save(ccd_salary, ccd_salary.getSheetSection() + "." + ccd_salary.getSheetName());
				
				// Hospital Core | Expense Analytics | (hc.ea) -> Cost Center Distribution - Total Expenses (DBNAME: ccd_total)
				SpecSheet ccd_total = new SpecSheet("hc", "ccd_total");
				ccd_total.addRecord(new RowRecord("A000000", "00400", "00300", "emp_benefits_dep", true), 1);
				ccd_total.addRecord(new RowRecord("A000000", "00500", "00300", "admin_and_gen", true), 2);
				ccd_total.addRecord(new RowRecord("A000000", "00600", "00300", "main_and_repairs", true), 3);
				ccd_total.addRecord(new RowRecord("A000000", "00700", "00300", "op_of_plant", true), 4);
				ccd_total.addRecord(new RowRecord("A000000", "00800", "00300", "laundry_and_linen", true), 5);
				ccd_total.addRecord(new RowRecord("A000000", "00900", "00300", "housekeeping", true), 6);
				ccd_total.addRecord(new RowRecord("A000000", "01000", "00300", "dietary", true), 7);
				ccd_total.addRecord(new RowRecord("A000000", "01100", "00300", "cafeteria", true), 8);
				ccd_total.addRecord(new RowRecord("A000000", "01200", "00300", "main_of_personnel", true), 9);
				ccd_total.addRecord(new RowRecord("A000000", "01300", "00300", "nursing_admin", true), 10);
				ccd_total.addRecord(new RowRecord("A000000", "01400", "00300", "central_serv_and_sup", true), 11);
				ccd_total.addRecord(new RowRecord("A000000", "01500", "00300", "pharmacy", true), 12);
				ccd_total.addRecord(new RowRecord("A000000", "01600", "00300", "med_rec_and_lib", true), 13);
				ccd_total.addRecord(new RowRecord("A000000", "01700", "00300", "soc_serv", true), 14);
				ccd_total.addRecord(new RowRecord("A000000", "03000", "00300", "adult_and_ped", true), 15);
				ccd_total.addRecord(new RowRecord("A000000", "03100", "00300", "icu", true), 16);
				ccd_total.addRecord(new RowRecord("A000000", "03200", "00300", "ccu", true), 17);
				ccd_total.addRecord(new RowRecord("A000000", "03300", "00300", "bicu", true), 18);
				ccd_total.addRecord(new RowRecord("A000000", "03400", "00300", "sicu", true), 19);
				ccd_total.addRecord(new RowRecord("A000000", "05000", "00300", "op_room", true), 20);
				ccd_total.addRecord(new RowRecord("A000000", "05100", "00300", "recov_room", true), 21);
				ccd_total.addRecord(new RowRecord("A000000", "05200", "00300", "labor_delivery_room", true), 22);
				ccd_total.addRecord(new RowRecord("A000000", "05300", "00300", "anesthesiology", true), 23);
				ccd_total.addRecord(new RowRecord("A000000", "05400", "00300", "radiology_diag", true), 24);
				ccd_total.addRecord(new RowRecord("A000000", "05500", "00300", "radiology_therap", true), 25);
				ccd_total.addRecord(new RowRecord("A000000", "05600", "00300", "radioisotope", true), 26);
				ccd_total.addRecord(new RowRecord("A000000", "05700", "00300", "ct_scan", true), 27);
				ccd_total.addRecord(new RowRecord("A000000", "05800", "00300", "mri", true), 28);
				ccd_total.addRecord(new RowRecord("A000000", "05900", "00300", "cardiac_cath", true), 29);
				ccd_total.addRecord(new RowRecord("A000000", "06000", "00300", "laboratory", true), 30);
				ccd_total.addRecord(new RowRecord("A000000", "06100", "00300", "pbp_clinical", true), 31);
				ccd_total.addRecord(new RowRecord("A000000", "06200", "00300", "blood_cells", true), 32);
				ccd_total.addRecord(new RowRecord("A000000", "06300", "00300", "blood_store_proc_trans", true), 33);
				ccd_total.addRecord(new RowRecord("A000000", "06400", "00300", "iv_therap", true), 34);
				ccd_total.addRecord(new RowRecord("A000000", "06500", "00300", "resp_therap", true), 35);
				ccd_total.addRecord(new RowRecord("A000000", "06600", "00300", "phys_therap", true), 36);
				ccd_total.addRecord(new RowRecord("A000000", "06700", "00300", "occup_therap", true), 37);
				ccd_total.addRecord(new RowRecord("A000000", "06800", "00300", "speech_path", true), 38);
				ccd_total.addRecord(new RowRecord("A000000", "06900", "00300", "electrocardio", true), 39);
				ccd_total.addRecord(new RowRecord("A000000", "07000", "00300", "electroenceph", true), 40);
				ccd_total.addRecord(new RowRecord("A000000", "07100", "00300", "med_sup_chrg_to_pat", true), 41);
				ccd_total.addRecord(new RowRecord("A000000", "07200", "00300", "implant_dev_chrg_to_pat", true), 42);
				ccd_total.addRecord(new RowRecord("A000000", "07300", "00300", "drugs_chrg_to_pat", true), 43);
				ccd_total.addRecord(new RowRecord("A000000", "07400", "00300", "renal_dialysis", true), 44);
				ccd_total.addRecord(new RowRecord("A000000", "09100", "00300", "emergency", true), 45);
				ccd_total.addRecord(new RowRecord("A000000", "11800", "00300", "subtotal", true), 46);
				ccd_total.addRecord(new RowRecord("A000000", "20000", "00300", "total", true), 47);
				packager.save(ccd_total, ccd_total.getSheetSection() + "." + ccd_total.getSheetName());
				
				// Hospital Core | Financial Ratios | (hc.ea) -> Average Age of Plant (DBNAME: finstat_aaop)
				SpecSheet finstat_aaop = new SpecSheet("hc.ratios", "average_age_of_plant");
				finstat_aaop.addRecord(new RowRecord("G000000", "01400", "00100", "accum1", true), 1);
				finstat_aaop.addRecord(new RowRecord("G000000", "01600", "00100", "accum2", true), 2);
				finstat_aaop.addRecord(new RowRecord("G000000", "01800", "00100", "accum3", true), 3);
				finstat_aaop.addRecord(new RowRecord("G000000", "02000", "00100", "accum4", true), 4);
				finstat_aaop.addRecord(new RowRecord("G000000", "02200", "00100", "accum5", true), 5);
				finstat_aaop.addRecord(new RowRecord("G000000", "02400", "00100", "accum6", true), 6);
				finstat_aaop.addRecord(new RowRecord("G000000", "02600", "00100", "accum7", true), 7);
				finstat_aaop.addRecord(new RowRecord("G000000", "02800", "00100", "accum8", true), 8);
				finstat_aaop.addRecord(new RowRecord("A700002", "00300", "00900", "dep_expense", true), 9);
				packager.save(finstat_aaop, finstat_aaop.getSheetSection() + "." + finstat_aaop.getSheetName());
				
				// Hospital Core | Financial Ratios | (hc.ea) -> Days in Accounts Receivable/Current Assets (DBNAME: finstat_ca)
				SpecSheet finstat_ca = new SpecSheet("hc.ratios", "current_assets");
				finstat_ca.addRecord(new RowRecord("G000000", "00100", "00100", "coh_and_banks", false), 1);
				finstat_ca.addRecord(new RowRecord("G000000", "00200", "00100", "temp_investments", false), 2);
				finstat_ca.addRecord(new RowRecord("G000000", "00300", "00100", "notes_receivable", false), 3);
				finstat_ca.addRecord(new RowRecord("G000000", "00400", "00100", "accounts_receivable", false), 4);
				finstat_ca.addRecord(new RowRecord("G000000", "00500", "00100", "other_receivables", false), 5);
				finstat_ca.addRecord(new RowRecord("G000000", "00600", "00100", "afun_and_ar", false), 6);
				finstat_ca.addRecord(new RowRecord("G000000", "00700", "00100", "inventory", false), 7);
				finstat_ca.addRecord(new RowRecord("G000000", "00800", "00100", "prepaid_expenses", false), 8);
				finstat_ca.addRecord(new RowRecord("G000000", "00900", "00100", "other_cur_assets", false), 9);
				finstat_ca.addRecord(new RowRecord("G000000", "01000", "00100", "due_from_other_funds", false), 10);
				finstat_ca.addRecord(new RowRecord("G000000", "01100", "00100", "total_current_assets", false), 11);
				packager.save(finstat_ca, finstat_ca.getSheetSection() + "." + finstat_ca.getSheetName());
				
				// Hospital Core | Financial Ratios | (hc.ea) -> Current Liabilities (DBNAME: finstat_cl)
				SpecSheet finstat_cl = new SpecSheet("hc.ratios", "current_liabilities");
				finstat_cl.addRecord(new RowRecord("G000000", "03700", "00100", "accounts_payable", false), 1);
				finstat_cl.addRecord(new RowRecord("G000000", "03800", "00100", "salaries_wages_fees_payable", false), 2);
				finstat_cl.addRecord(new RowRecord("G000000", "03900", "00100", "payroll_taxes_payable", false), 3);
				finstat_cl.addRecord(new RowRecord("G000000", "04000", "00100", "notes_loans_payable", false), 4);
				finstat_cl.addRecord(new RowRecord("G000000", "04100", "00100", "deferred_income", false), 5);
				finstat_cl.addRecord(new RowRecord("G000000", "04500", "00100", "total_current_liabilities", false), 6);
				packager.save(finstat_cl, finstat_cl.getSheetSection() + "." + finstat_cl.getSheetName());
				
				// Hospital Core | Financial Statements | (hc.ea) -> EBITDA (DBNAME: finstat_ebitda)
				SpecSheet finstat_ebitda = new SpecSheet("hc.ratios", "current_liabilities");
				finstat_ebitda.addRecord(new RowRecord("G000000", "03700", "00100", "accounts_payable", false), 1);
				finstat_ebitda.addRecord(new RowRecord("G000000", "03800", "00100", "salaries_wages_fees_payable", false), 2);
				finstat_ebitda.addRecord(new RowRecord("G000000", "03900", "00100", "payroll_taxes_payable", false), 3);
				finstat_ebitda.addRecord(new RowRecord("G000000", "04000", "00100", "notes_loans_payable", false), 4);
				finstat_ebitda.addRecord(new RowRecord("G000000", "04100", "00100", "deferred_income", false), 5);
				finstat_ebitda.addRecord(new RowRecord("G000000", "04500", "00100", "total_current_liabilities", false), 6);
				packager.save(finstat_ebitda, finstat_ebitda.getSheetSection() + "." + finstat_ebitda.getSheetName());
				
				
	//Hospital Core End --!>
	}
	
	public static void main (String[] args)
	{
		SpecSheetMapper ssm = new SpecSheetMapper();
		ssm.updateMappings();
	}
}
