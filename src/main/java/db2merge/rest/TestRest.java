package db2merge.rest;

import java.util.List;

import db2merge.dto.UserData;
import db2merge.reposiroty.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRest {
    private final UserDataRepository userDataRepository;

    @Autowired
    public TestRest(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    @PostMapping("/test")
    public ResponseEntity<List<UserData>> example() {
        List<UserData> userDataList = userDataRepository.findAll();
        return new ResponseEntity<>(userDataList, HttpStatus.OK);
    }
}