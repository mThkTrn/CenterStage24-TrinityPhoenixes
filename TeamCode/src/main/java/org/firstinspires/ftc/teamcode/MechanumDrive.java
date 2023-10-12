package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.EnumMap;



@TeleOp(name = "PowerPlay Mechanum Drive", group = "TeleOP")
public class MechanumDrive extends LinearOpMode {

        private DcMotor frontLeft = null;
        private DcMotor frontRight = null;
        private DcMotor backLeft = null;
        private DcMotor backRight = null;
        private double MECANUM_SPEED = -1;
        private double ROTATION_SPEED = -1;
//    Gamepad gamepad2 = gamepad1; // uncomment for IAN MODE

    private void mecanumDrive(){
//        double rx = gamepad1.right_stick_x;
//        double lx = gamepad1.left_stick_x;
//        double ly = gamepad1.left_stick_y;
//
//        double robot_ang = Math.atan2(ly, lx) - Math.PI / 4;
//        double r = Math.hypot(lx, ly);
//        double v1 = r * Math.cos(robot_ang) + rx;
//        double v2 = r * Math.sin(robot_ang) - rx;
//        double v3 = r * Math.sin(robot_ang) + rx;
//        double v4 = r * Math.cos(robot_ang) - rx;
//
//        frontLeft.setPower(v2);
//        frontRight.setPower(v1);
//        backLeft.setPower(v4);
//        backRight.setPower(v3);
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;
        double r = gamepad1.right_stick_x;
        drivePower(x, y, r);


    }
    private void drivePower(double x, double y, double r){
        x *= -MECANUM_SPEED;
        y *= -MECANUM_SPEED;
        r *= -ROTATION_SPEED;
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(r), 1);

        frontLeft.setPower(-(y + x + r));
        frontRight.setPower((y - x - r));
        backLeft.setPower(-(y - x + r));
        backRight.setPower((y + x - r));
    }
    @Override
    public void runOpMode() {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        telemetry.addData("start", "hello world :>");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            mecanumDrive();

            // arm control
//            if (gamepad2.a && !risingA) {
//                robotOld.setArm(RobotOld.ArmState.GROUND);
//            } else if (gamepad2.b && !risingB) {
//                robotOld.setArm(RobotOld.ArmState.HIGH);
//            } else if (gamepad2.x && !risingX) {
//                robotOld.setArm(RobotOld.ArmState.LOW);
//            } else if (gamepad2.y && !risingY) {
//                robotOld.setArm(RobotOld.ArmState.MEDIUM);
//            }
//
//            risingA = gamepad2.a;
//            risingB = gamepad2.b;
//            risingX = gamepad2.x;
//            risingY = gamepad2.y;
        }
    }
}

// 14413!

// /\__/\
// (=o.o=)
// |/--\|
// (")-(")