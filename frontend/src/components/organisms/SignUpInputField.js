import React from 'react';
import TaggedInputField from '../molecules/TaggedInputField';
import SubmitButton from '../../components/atoms/SubmitButton';
import IdInputField from '../molecules/IdInputField';
import '../css/AlignCenter.css'

const SignUpInputField=(props)=>{
    
    return (
        <div class="centered">
            <IdInputField label="아이디 입력"/>
            <TaggedInputField label="비밀번호 입력" inputType="password"/>
            <TaggedInputField label="비밀번호 입력 확인" inputType="password"/>
            <TaggedInputField label="이름 입력"/>
            <TaggedInputField label="주소 입력"/>
            <TaggedInputField label="전화번호 입력" holder="' - ' 없이 입력해 주세요."/>

            <SubmitButton label="회원가입 하기"/>
        </div>
    )
}

export default SignUpInputField;