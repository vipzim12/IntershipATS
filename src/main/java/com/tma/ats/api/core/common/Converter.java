package com.tma.ats.api.core.common;

public interface Converter<D, B> {
	public B convert(D value);
}