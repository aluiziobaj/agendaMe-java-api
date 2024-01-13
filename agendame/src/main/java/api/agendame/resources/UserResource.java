package api.agendame.resources;

import api.agendame.models.UserModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserResource {
    public HashMap toHashMap(UserModel userModel){
        HashMap map = new HashMap();
        map.put("id", userModel.getId());
        map.put("nome", userModel.getNome());
        map.put("email", userModel.getEmail());
        return  map;
    }
}
