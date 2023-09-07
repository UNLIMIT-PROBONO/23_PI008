import React, { useState } from "react";
import { LoginBox } from "../components/organisms/auth/LoginBox";
import { sendLoginForm } from "../services/AuthService";
import { toasting } from "../hook/UseToast";
import { ToastContainer } from "react-toastify";
import { Col, Row } from "antd";
import { useNavigate } from "react-router";

export const LoginPage = () => {
  const [loginData, setLoginData] = useState({
    loginId: "",
    password: "",
  });
  const router = useNavigate();

  const loginDataHandler = (data) => {
    setLoginData(data);
  };

  const onClickLoginBtn = async () => {
    var loginSuccess = await sendLoginForm(loginData);
    if (loginSuccess) {
      console.log(loginData.loginId + "님이 로그인 했습니다.");
      toasting("로그인 성공!", "success");
      // 메인 화면으로 라우팅
      router("../main");
      return;
    }
    toasting("다시 확인해 주세요", "error");
  };

  return (
    <Row>
      <ToastContainer />
      <Col>
        <LoginBox
          values={loginData}
          loginDataHandler={loginDataHandler}
          onClickLoginBtn={onClickLoginBtn}
        />
      </Col>
      <Col>홍보 사진</Col>
    </Row>
  );
};
//https://ant.design/components/grid
