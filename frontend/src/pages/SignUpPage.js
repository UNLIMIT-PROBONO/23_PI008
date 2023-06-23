import React, { useState } from 'react';
import SignUpInputField from '../components/organisms/SignUpInputField';
import TogetherLogo from '../components/molecules/TogetherLogo'
import { checkIdVerification, sendSignUpForm } from '../services/AuthService';
import { isBlank } from '../utils/validator';

function SignUpPage() {
    var [idLock, setIdLock] = useState(false);

    const [userData, setUserData] = useState({
        login_id : '',
        password: '',
        name: '',
        phone_number: '',
        area: '',
    });

    const userDataHandler= (data)=> {
        setUserData(data);
    }

    const onClickSubmitBtn= async ()=> {
        if(!permittedToUseId()) return;
        if(!inputedSamePassword()) return;
        if(haveBlankFields()) return;
        console.log(userData.login_id+"님이 회원가입");
        await sendSignUpForm(userData);
        // 라우팅
    }
    
    const onClickIdCheck= async ()=> {
        setIdLock(await checkIdVerification(userData.login_id));
        if(!idLock){
            alert("사용 가능한 아이디입니다.");
            return;
        }
        alert("이미 존재하는 아이디입니다.");
    }

    const haveBlankFields= ()=> {
        if(Object.values(userData).filter(v=> isBlank(v)).length > 0){
            console.log("assda");
            alert("모든 값을 입력해주세요.");
            return true;
        }
        return false;
    }

    const permittedToUseId= ()=> {
        if(!idLock){
            alert("아이디 중복 확인을 해주세요.");
            return false;
        }
        return true;
    }

    const inputedSamePassword= ()=> {
        if(userData.password !== userData.passwordCheck){
            alert("비밀번호를 확인해 주세요.")
            return false;
        }
        return true;
    }

    return (
        <div>
            <TogetherLogo />
            <SignUpInputField 
                values={userData}
                idLock={idLock}
                userDataHandler={userDataHandler}
                onClickIdCheck={onClickIdCheck}
                onClickSubmitBtn={onClickSubmitBtn}
            />
        </div>
    );
}

export default SignUpPage;