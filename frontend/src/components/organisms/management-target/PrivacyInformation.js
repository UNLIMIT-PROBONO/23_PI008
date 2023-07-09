import React from 'react';
import { Information } from '../../molecules/management-target/Information';
import { Col, Row } from 'antd';
import { Age } from '../../molecules/management-target/Age';

export function PrivacyInformation(props) {
    var {tgName, birth, address, phoneNumber} = props.data;
    
    return (
        <>
        <Row>
            <Col>
                <Information content={tgName}/>
            </Col>
            <Col>
                <Age birth={birth} />
            </Col>
        </Row>
        <Row>
            <Information label="주소" content={address}/>
        </Row>
        <Row>    
            <Information label="번호" content={phoneNumber}/>
        </Row>
        </>
    )
}