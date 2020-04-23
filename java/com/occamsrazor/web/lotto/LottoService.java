package com.occamsrazor.web.lotto;

public interface LottoService {

	public void buy(Lotto lotto);
	public void add(Lotto lotto);
	public int count();
	public int[] result(int[] numbers);
}
