package com.exam.mybatis01;

import java.util.List;

import model1.ZipcodeTO;

public interface TestMapper {
	public abstract List<ZipcodeTO> selectZipcode(String dong);
}
