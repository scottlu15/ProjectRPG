package com.universalred.projectRPG;

import java.util.logging.*;

import com.universalred.projectRPG.game.*;
import com.universalred.projectRPG.menu.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ProjectRPG extends StateBasedGame {

    public static final int menu = 0;
    public static final int play = 1;
    public static String projectRPG = "Project RPG";

    public ProjectRPG(String gamename) {
        super(gamename);
        this.addState(new Menu(menu));
        this.addState(new Play(play));
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.getState(menu).init(gameContainer, this);
        this.getState(play).init(gameContainer, this);
        this.enterState(menu);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new ProjectRPG(projectRPG));
            appgc.setDisplayMode(640, 480, false);
            appgc.start();
        }
        catch (SlickException ex) {
            Logger.getLogger(ProjectRPG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}