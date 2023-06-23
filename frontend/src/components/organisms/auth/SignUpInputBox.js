import React, { useEffect, useState } from 'react';
import TaggedInputField from '../../molecules/auth/TaggedInputField';
import SubmitButton from '../../atoms/SubmitButton';
import IdInputField from '../../molecules/auth/IdInputField';
import '../../css/AlignCenter.css'

const SignUpInputBox=(props)=>{
    const [userData, setUserData] = useState(props.values);
    var handleParent = props.userDataHandler;

    const handleInput= (tag)=>{
        return (event)=>{
            userData[tag]=event.target.value;
            setUserData({...userData})
            handleParent(userData);
        }
    }

    return (
        <div class="centered">
            <IdInputField 
                label="아이디 입력" 
                value={userData.login_id} 
                lock={props.idLock}
                onClick={props.onClickIdCheck}
                onChange={handleInput("login_id")}
                />
            <TaggedInputField 
                label="비밀번호 입력" 
                inputType="password" 
                value={userData.password}
                onChange={handleInput("password")}
                />
            <TaggedInputField 
                label="비밀번호 입력 확인" 
                inputType="password" 
                value={userData.passwordCheck}
                onChange={handleInput("passwordCheck")}
                />
            <TaggedInputField 
                label="이름 입력" 
                value={userData.name}
                onChange={handleInput("name")}
                />
            <TaggedInputField 
                label="주소 입력" 
                value={userData.area}
                onChange={handleInput("area")}
                />
            <TaggedInputField 
                label="전화번호 입력" 
                value={userData.phone_number} 
                holder="' - ' 없이 입력해 주세요."
                onChange={handleInput("phone_number")}
                />

            <SubmitButton 
                label="회원가입 하기"
                onClick={props.onClickSubmitBtn}/>
        </div>
    )
}

export default SignUpInputBox;