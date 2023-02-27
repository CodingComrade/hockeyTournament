package capstone.service;


import capstone.entity.Player;

import java.util.List;

public interface PlayerService {

    public List<Player> findAll();

    public Player findById(int theId);

    public void save(Player thePlayer);

    public void deleteById(int theId);

}
