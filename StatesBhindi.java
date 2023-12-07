package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.ArmForBhindi;
import org.firstinspires.ftc.teamcode.ClawForBhindi;

public class StatesBhindi {

    public ClawForBhindi claw;
    public ArmForBhindi arm;

    public statePos states;

    public String stage_arm = "rest";
    public String stage_claw = "close";

    public StatesBhindi(ClawForBhindi claw, ArmForBhindi arm){
        this.claw = claw;
        this.arm = arm;

        states = statePos.INIT;
    }
    public void update(){
        switch (states){
            case INIT:
                stage_arm = "rest";
                stage_claw = "close";
                break;
            case DEPOSIT:
                stage_arm = "deposit";
                break;
            case INTAKE:
                stage_arm = "intake";
                break;
            case CLAW_OPEN:
                stage_claw = "open";
                break;
            case CLAW_CLOSE:
                stage_claw = "close";
                break;
        }

        claw.set(stage_claw);
        arm.setArm(stage_arm);
        arm.setArmExtend(stage_arm);
    }
    
    public void setStatePos(statePos state){
        states = state;
    }

    public enum statePos {
        INIT,
        DEPOSIT,
        INTAKE,
        CLAW_OPEN,
        CLAW_CLOSE
    }
}
