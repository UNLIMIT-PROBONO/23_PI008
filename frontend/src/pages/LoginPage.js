import React, { useState } from 'react';
import { LoginBox } from '../components/organisms/auth/LoginBox';
import { sendLoginForm } from '../services/AuthService';
import { toasting } from '../hook/UseToast';
import { ToastContainer } from 'react-toastify';
import { Col, Row } from 'antd';
import AdvImage from '../assets/AdvImage.jpg';
import MainLogo from '../assets/mainLogo.png';

export function LoginPage() {
  const [loginData, setLoginData] = useState({
    login_id: '',
    password: '',
  });

  const loginDataHandler = data => {
    setLoginData(data);
  };

  const onClickLoginBtn = async () => {
    var loginSuccess = await sendLoginForm(loginData);
    if (loginSuccess) {
      console.log(loginData.login_id + '님이 로그인 했습니다.');
      toasting('로그인 성공!', 'success');
      // 메인 화면으로 라우팅
      return;
    }
    console.log(loginData);
    toasting('다시 확인해 주세요', 'error');
  };

  return (
    <Row style={{ height: '100vh', overflow: 'hidden' }}>
      <ToastContainer />
      <Col
        span={10}
        style={{
          display: 'flex',
          flexDirection: 'column',
          justifyContent: 'center',
          alignItems: 'center',
          padding: '1rem 0 0 0',
        }}
      >
        <div style={{ display: 'flex', alignItems: 'center', marginBottom: '4rem' }}>
          <img id="mainLogo" src={MainLogo} alt="메인로고" style={{ marginRight: '0.5rem' }}></img>
          <div>
            <div style={{ fontSize: '2rem', fontWeight: 'bold', marginBottom: '0.5rem' }}>아울러</div>
            <div style={{ fontSize: '1.25rem' }}>사회복지사의 관리 모니터링</div>
          </div>
        </div>
        <LoginBox values={loginData} loginDataHandler={loginDataHandler} onClickLoginBtn={onClickLoginBtn} />
      </Col>
      <Col
        span={14}
        style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', backgroundColor: '#D9D9D9' }}
      >
        <img id="mainImage" src={AdvImage} alt="홈화면" style={{ maxWidth: '100%', maxHeight: '100%' }}></img>
      </Col>
    </Row>
  );
}
//https://ant.design/components/grid
