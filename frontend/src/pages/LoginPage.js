import React, { useState } from "react";
import { LoginBox } from "../components/organisms/auth/LoginBox";
import { sendLoginForm } from "../services/AuthService";
import { toasting } from "../hook/UseToast";
import { ToastContainer } from "react-toastify";
import { Col, Row } from "antd";
import { useNavigate } from "react-router";
import seniorCouple from "../assets/Senior-Couple.png";
import styled from "styled-components";

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
      <CenterWrap>
        <Col>
          <LoginBox
            values={loginData}
            loginDataHandler={loginDataHandler}
            onClickLoginBtn={onClickLoginBtn}
          />
        </Col>
        <Col>
          <img
            src={seniorCouple}
            style={{
              width: "auto",
              height: "90vh",
              marginLeft: "10px",
              objectFit: "cover",
              objectPosition: "0 50 0 0",
              overflow: "hidden",
            }}
          />
        </Col>
      </CenterWrap>
    </Row>
  );
};

const CenterWrap = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 20px;
  // margin-top: 100px;
`;
