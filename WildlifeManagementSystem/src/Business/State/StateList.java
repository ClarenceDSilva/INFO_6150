/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.State;

import Business.Enterprise.EnterpriseDirectory;
import java.util.ArrayList;

/**
 *
 * @author Aditya Kelkar
 */
public class StateList {

    private ArrayList<State> stateList;

    public StateList() {
        stateList = new ArrayList<>();
    }

    public ArrayList<State> getStateList() {
        return stateList;
    }

    public State addState() {
        State state = new State();
        stateList.add(state);
        EnterpriseDirectory e = new EnterpriseDirectory();
        state.setEnterpriseDirectory(e);
        return state;
    }
}
