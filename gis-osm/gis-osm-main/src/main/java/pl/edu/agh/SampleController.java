package pl.edu.agh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SampleController {

    SampleDao sampleDao;

    @Autowired
    public SampleController(SampleDao sampleDao) {
        this.sampleDao = sampleDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody SampleEntity operation() {
        String s = sampleDao.getValues();
        SampleEntity sampleEntity = new SampleEntity(s);
        return sampleEntity;
    }

}
