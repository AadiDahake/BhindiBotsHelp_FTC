package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.ArmForBhindi;
import org.firstinspires.ftc.teamcode.ClawForBhindi;
import org.firstinspires.ftc.teamcode.DrivetrainBhindi;
import org.firstinspires.ftc.teamcode.StatesBhindi;

@Config
@TeleOp(name = "TeleOp with PID", group = "Robot")
public class TeleOpwithPID extends LinearOpMode {

    StatesBhindi states;
    org.firstinspires.ftc.teamcode.ArmForBhindi arm;
    ClawForBhindi claw;

    DrivetrainBhindi drive;


    @Override
    public void runOpMode() throws InterruptedException {

        claw = new ClawForBhindi(hardwareMap);
        arm = new org.firstinspires.ftc.teamcode.ArmForBhindi(hardwareMap);

        states = new StatesBhindi(claw, arm);

        Gamepad currentGamepad1 = new Gamepad();
        Gamepad currentGamepad2 = new Gamepad();

        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

        drive = new DrivetrainBhindi(hardwareMap, gamepad1);

        waitForStart();
        while (opModeIsActive()) {

            if (currentGamepad2.x && !previousGamepad2.x){
                states.setStatePos(StatesBhindi.statePos.CLAW_CLOSE);
            }
            if (currentGamepad2.y && !previousGamepad2.y){
                states.setStatePos(StatesBhindi.statePos.CLAW_OPEN);
            }

            if (currentGamepad2.a && !previousGamepad2.a){
                states.setStatePos(StatesBhindi.statePos.INTAKE);
            }

            if (currentGamepad2.b && !previousGamepad2.b){
                states.setStatePos(StatesBhindi.statePos.DEPOSIT);
            }

            states.update();
            drive.move();
        }


    }
}