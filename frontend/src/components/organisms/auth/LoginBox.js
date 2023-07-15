import React, { useState } from "react";
import { LoginInputField } from "../../molecules/auth/LoginInputField";
import SubmitButton from "../../atoms/SubmitButton";
import { TextToSignUp } from "../../molecules/auth/TextToSignUp";

export function LoginBox(props) {
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
    <div>
      <div>
        <LoginInputField
          label="아이디"
          value={loginData.login_id}
          onChange={handleInput("login_id")}
        />
        <LoginInputField
          label="비밀번호"
          inputType="password"
          value={loginData.password}
          onChange={handleInput("password")}
        />
        <SubmitButton label="로그인" onClick={props.onClickLoginBtn} />
      </div>
      <TextToSignUp />
    </div>
  );
}
