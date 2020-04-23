package com.occamsrazor.web.lotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messager;

@RestController
@RequestMapping("/lotto")
public class LottoController {

	@Autowired LottoService lottoService;
	
	@PostMapping("/buy")
	public Messager buy(@RequestBody Lotto lotto) {
		
		int current = lottoService.count();
		lottoService.add(lotto);
		System.out.println(lotto);
		return (lottoService.count() == (current+1))?Messager.SUCCESS:Messager.FAIL;
	}
	
	@PostMapping()
	public void result() {
		
	}
	
}
