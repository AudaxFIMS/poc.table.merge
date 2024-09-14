package db2merge.reposiroty;

import java.util.List;

import db2merge.dto.UserData;

public interface UserDataRepository {
    List<UserData> findAll();
}
