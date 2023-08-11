import React, { useState } from 'react';
import { LoginInputField } from '../../molecules/auth/LoginInputField';
import SubmitButton from '../../atoms/SubmitButton';
import { TextToSignUp } from '../../molecules/auth/TextToSignUp';

export function LoginBox(props) {
  const [loginData, setLoginData] = useState(props.values);
  var handleParent = props.loginDataHandler;

  const handleInput = tag => {
    return event => {
      loginData[tag] = event.target.value;
      setLoginData({ ...loginData });
      handleParent(loginData);
    };
  };

  return (
    <div style={{ width: '20rem' }}>
      {' '}
      {/* 300px */}
      <div style={{ marginBottom: '1rem' }}>
        <LoginInputField
          label="아이디"
          fontWeight="bold"
          value={loginData.login_id}
          onChange={handleInput('login_id')}
        />
      </div>
      <div style={{ marginBottom: '2.5rem' }}>
        <LoginInputField
          label="비밀번호"
          fontWeight="bold"
          inputType="password"
          value={loginData.password}
          onChange={handleInput('password')}
        />
      </div>
      <SubmitButton label="로그인" onClick={props.onClickLoginBtn} />
      <div style={{ marginBottom: '1rem' }}></div>
      <TextToSignUp />
      <div style={{ marginBottom: '8rem' }}></div>
    </div>
  );
}
