import React, { useState } from "react";
import { LoginInputField } from "../../molecules/auth/LoginInputField";
import { SubmitButton } from "../../atoms/SubmitButton";
import { TextToSignUp } from "../../molecules/auth/TextToSignUp";
import { TogetherLogo } from "./../../molecules/TogetherLogo";

export const LoginBox = (props) => {
  const [loginData, setLoginData] = useState(props.values);
  var handleParent = props.loginDataHandler;

  const handleInput = (tag) => {
    return (event) => {
      loginData[tag] = event.target.value;
      setLoginData({ ...loginData });
      handleParent(loginData);
    };
  };

  return (
    <div style={{ width: "400px", margin: "10px" }}>
      <TogetherLogo />
      <div style={{ alignItems: "center", justifyContent: "center" }}>
        <LoginInputField
          label="아이디"
          value={loginData.loginId}
          onChange={handleInput("loginId")}
        />
        <LoginInputField
          label="비밀번호"
          inputType="password"
          value={loginData.password}
          onChange={handleInput("password")}
        />
        <SubmitButton label="로그인" onClick={props.onClickLoginBtn} />
      </div>

      <div style={{ marginTop: "20px", marginLeft: "15px" }}>
        <TextToSignUp />
      </div>
    </div>
  );
};
