package com.astro.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.astro.domain.Person;
import com.astro.domain.Resp;
import com.astro.domain.Sunsign;
import com.astro.repo.PersonRepository;
import com.astro.repo.SunsignRepositiry;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/scorpio")
public class SampleController {
	
	@Autowired
	SunsignRepositiry sunsignRepo;
	
	@Autowired
	PersonRepository personRepo;
		
    @RequestMapping(path="/heee",method=RequestMethod.GET)
    public @ResponseBody Resp sayHello(@RequestParam(value="name")String name) {
    	System.out.println("name:"+name);
        return new Resp(name);
    }
    
    @RequestMapping(path="/getSigns",method=RequestMethod.GET)
    public @ResponseBody List<Sunsign> getSigns(){
    	return (List<Sunsign>) sunsignRepo.findAll();
    }
    
    @RequestMapping(path="/getSignsData",method=RequestMethod.GET)
    public @ResponseBody List<Sunsign> getSigns(@RequestParam String signName){
    	return sunsignRepo.findBySign(signName);
    }
    
    @RequestMapping(path="/getSignsIn",method=RequestMethod.GET)
    public @ResponseBody List<Sunsign> getSigns(@RequestParam List<String> signs){
    	return sunsignRepo.findBySignIn(signs);
    }
    
    @RequestMapping(path="/getsorted" , method=RequestMethod.GET)
    public @ResponseBody Iterable<Person> getsorted(){
    	Sort sort = new Sort(new String[]{"sign"});
		return personRepo.findAll(sort);
    }
    
    @RequestMapping(path="/getall" , method=RequestMethod.GET)
    public @ResponseBody Iterable<Person> getall(){
		return personRepo.findAll();
    }
    
    @RequestMapping(path="/getcount" , method=RequestMethod.GET)
    public @ResponseBody Integer getcount(){
		return personRepo.countBySign("scorpio");
    }
}
