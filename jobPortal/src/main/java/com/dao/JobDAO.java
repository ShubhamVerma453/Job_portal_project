package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Jobs;

public class JobDAO {
	private Connection conn;

	public JobDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addJobs(Jobs j) {
		boolean f = false;

		try {
			String str = "insert into job_portal.jobs (title, description, category, status, location) values (?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Jobs> getAllJobs() {
		List<Jobs> list = new ArrayList<>();
		Jobs j = null;
		try {
			String str = "select * from job_portal.jobs order by id desc;";
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Jobs> getAllJobsForUser() {
		List<Jobs> list = new ArrayList<>();
		Jobs j = null;
		try {
			String str = "select * from job_portal.jobs where status = ? order by id desc;";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Jobs getJobById(int id) {
		Jobs j = null;
		try {
			String str = "select * from job_portal.jobs where id=?;";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return j;
	}

	public boolean updateJob(Jobs j) {
		boolean f = false;
		try {
			String str = "update job_portal.jobs set title=?, description=?, category=?, status=?, location=?  where id=?";

			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			ps.setInt(6, j.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteJobById(int id) {
		boolean f = false;
		try {
			String str = "delete from job_portal.jobs where id=?";
			
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	
	public List<Jobs> getJobORLocAndCat(String location, String category){
		List<Jobs> list = new ArrayList<>();
		Jobs j = null;
		try {
			String str = "select * from job_portal.jobs where location = ? and status = ? or category = ? and status = ? order by id desc;";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, location);
			ps.setString(2, "Active");
			ps.setString(3, category);
			ps.setString(4, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Jobs> getJobAndLocAndCat(String location, String category){
		List<Jobs> list = new ArrayList<>();
		Jobs j = null;
		try {
			String str = "select * from job_portal.jobs where status = ? and category = ? and location = ? order by id desc;";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, "Active");
			ps.setString(2, category);
			ps.setString(3, location);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
