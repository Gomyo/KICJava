package com.exam.mybatis01;

import java.util.List;

import model1.DeptTO;

public interface TestMapper {
	public abstract String selectNow();
	public abstract List<DeptTO> selectDept();
}
