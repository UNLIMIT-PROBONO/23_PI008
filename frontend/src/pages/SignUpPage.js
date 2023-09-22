import React, { useState } from "react";
import { SignUpInputBox } from "../components/organisms/auth/SignUpInputBox";
import { TogetherLogo } from "../components/molecules/TogetherLogo";
import { checkIdVerification, sendSignUpForm } from "../services/AuthService";
import { isBlank } from "../utils/validator";
import { useNavigate } from "react-router";
import { Col, Row } from "antd";
import seniorCouple from "../assets/Senior-Couple.png";
import styled from "styled-components";

export const SignUpPage = () => {
  const [idLock, setIdLock] = useState(false);
  const router = useNavigate();

  const [userData, setUserData] = useState({
    loginId: "",
    password: "",
    name: "",
    phoneNumber: "",
    adminArea: "",
  });

  const userDataHandler = (data) => {
    setUserData(data);
  };

  const onClickSubmitBtn = async () => {
    if (!permittedToUseId()) return;
    if (!inputedSamePassword()) return;
    if (haveBlankFields()) return;
    console.log(userData.loginId + "님이 회원가입");
    await sendSignUpForm(userData);

    router("../");
  };

  const onClickIdCheck = async () => {
    const result = await checkIdVerification(userData.loginId);
    if (result) {
      setIdLock(true);
      alert("사용 가능한 아이디입니다.");
      return;
    }
    alert("이미 존재하는 아이디입니다.");
  };

  const haveBlankFields = () => {
    if (Object.values(userData).filter((v) => isBlank(v)).length > 0) {
      alert("모든 값을 입력해주세요.");
      return true;
    }
    return false;
  };

  const permittedToUseId = () => {
    if (!idLock) {
      alert("아이디 중복 확인을 해주세요.");
      return false;
    }
    return true;
  };

  const inputedSamePassword = () => {
    if (userData.password !== userData.passwordCheck) {
      alert("비밀번호를 확인해 주세요.");
      return false;
    }
    return true;
  };

  return (
    <Row style={{ alignItems: "center", justifyContent: "center" }}>
      <Col>
        <CenterWrap>
          <TogetherLogo />
          <SignUpInputBox
            values={userData}
            idLock={idLock}
            userDataHandler={userDataHandler}
            onClickIdCheck={onClickIdCheck}
            onClickSubmitBtn={onClickSubmitBtn}
          />
        </CenterWrap>
      </Col>
      <Col>
        <img
          src={seniorCouple}
          style={{
            width: "auto",
            height: "90vh",
            objectFit: "cover",
            objectPosition: "0 50 0 0",
            overflow: "hidden",
          }}
        />
      </Col>
    </Row>
  );
};

const CenterWrap = styled.div`
  width: 400px;
  align-items: center;
  justify-content: center;
  margin: 10px;
`;
