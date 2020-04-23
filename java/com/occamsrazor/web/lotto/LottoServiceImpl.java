package com.occamsrazor.web.lotto;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class LottoServiceImpl implements LottoService {
	
	private Lotto[] lottos;
	private int count;
	
	
	public LottoServiceImpl() {
		lottos = new Lotto[5];
		count = 0;
	}
	
	
	
	@Override
	public void buy(Lotto lotto) {
		
		
		
	}



	public int[] result(int[] numbers) {
		numbers = new int[6];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if(numbers[i] == numbers[j]) {
					i--;
					break;
				}
			}
		}
		
		
		return numbers;
	}



	public void add(Lotto lotto) {
		
		lottos[count] = lotto;
		count++;
		String [] arr = lotto.getLotto().split(",");
		for (int i = 0; i < 6; i++) {
			Integer.parseInt(arr[i]);
		}
	}

	public int count() {
		
		return count;
	}
	
	
	
}
