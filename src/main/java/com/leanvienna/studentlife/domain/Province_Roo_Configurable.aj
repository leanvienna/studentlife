package com.leanvienna.studentlife.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Province_Roo_Configurable {
    
    declare @type: Province: @Configurable;
    
}
