package com.leanvienna.studentlife.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Course_Roo_Configurable {
    
    declare @type: Course: @Configurable;
    
}
