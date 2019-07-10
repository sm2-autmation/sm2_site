package com.eaf.qa.cloudops.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class AddingJobs {
	
	
	public AddingJobs(ThreadLocal<WebDriver> driver) {
		// TODO Auto-generated constructor stub
	}

	public enum Jobs {
		
		        A("A-Generator Maintenance 400 Hrs Maintenance"),
				B("B-Generator Maintenance 2000 Hrs"), 
				C("C-Generator Maintenance 10000 Hrs Maintenance"), 
				D("D-Generator Maintenance 20000 Hrs Maintenance");
		private String filter;

		/**
		 * Instantiates a new TimeZone.
		 *
		 * @param filter the filter
		 */
		Jobs(String filter) {
			this.filter = filter;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return filter;		
	}
	}
	
	
	
	public static final Map<String, String> staticMap = new HashMap<>();

	  static {
	      staticMap.put("A", "A-Generator Inspection 400 Hrs");
	      staticMap.put("B", "B-Generator Maintenance 2000 Hrs");
	      staticMap.put("C", "C- Generator Maintenance 10000 Hrs");
	      staticMap.put("D", "D- Generator Maintenance 20000 Hrs");
	     
	  }
	
	  public static final Map<String, String> staticMap2 = new HashMap<>();

	  static {
	      staticMap.put("A", "A-Generator Inspection 400 Hrs");
	      staticMap.put("B", "B-Generator Maintenance 2000 Hrs");
	      staticMap.put("C", "C- Generator Maintenance 10000 Hrs");
	      staticMap.put("D", "D- Generator Maintenance 20000 Hrs");
	     
	  }
	
	
}
