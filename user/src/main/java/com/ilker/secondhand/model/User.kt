package com.ilker.secondhand.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class User(
    @field: Id
    @field: GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ? = null,
    val mail:String,
    val firstName:String,
    val lastName:String,
    val middleName:String,
) {
    constructor(mail: String,firstName: String,lastName: String,middleName: String) : this(null,mail, firstName, lastName, middleName) {

    }

}

/*
* var -> getter metodlarını da getiriyor.
* val -> full immutable class'ın oluyor.
* class -> setter, getter constructor olmuyor.
* data class -> sadece içerisinde data barındıran bir class oluyor otomatikman sana tüm boiler plate kodları getiriyor
* */

/*
* Kotlin java vs. jvm tabanlı diller oldukları için entegrasyon maven gradle ayarı yaparak
* birlikte çalışmalarını sağlayabiliyoruz.
* */

/*
* Kotlinde set metodu olmadığı için bu data class'ı java tarafında initialize ederken
* tüm parametreleri constructor'a geçmem lazım.
* */

/*
* Spring official guidelineları kotlinleri data classları olarak spring data jpa ile kullanmamızı
* söylüyor. https://stackoverflow.com/questions/58127353/should-i-use-kotlin-data-class-as-jpa-entity
* */
