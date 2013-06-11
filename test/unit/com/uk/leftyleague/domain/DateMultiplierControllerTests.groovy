package com.uk.leftyleague.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(DateMultiplierController)
@Mock(DateMultiplier)
class DateMultiplierControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/dateMultiplier/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.dateMultiplierInstanceList.size() == 0
        assert model.dateMultiplierInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.dateMultiplierInstance != null
    }

    void testSave() {
        controller.save()

        assert model.dateMultiplierInstance != null
        assert view == '/dateMultiplier/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/dateMultiplier/show/1'
        assert controller.flash.message != null
        assert DateMultiplier.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/dateMultiplier/list'

        populateValidParams(params)
        def dateMultiplier = new DateMultiplier(params)

        assert dateMultiplier.save() != null

        params.id = dateMultiplier.id

        def model = controller.show()

        assert model.dateMultiplierInstance == dateMultiplier
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/dateMultiplier/list'

        populateValidParams(params)
        def dateMultiplier = new DateMultiplier(params)

        assert dateMultiplier.save() != null

        params.id = dateMultiplier.id

        def model = controller.edit()

        assert model.dateMultiplierInstance == dateMultiplier
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/dateMultiplier/list'

        response.reset()

        populateValidParams(params)
        def dateMultiplier = new DateMultiplier(params)

        assert dateMultiplier.save() != null

        // test invalid parameters in update
        params.id = dateMultiplier.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/dateMultiplier/edit"
        assert model.dateMultiplierInstance != null

        dateMultiplier.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/dateMultiplier/show/$dateMultiplier.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        dateMultiplier.clearErrors()

        populateValidParams(params)
        params.id = dateMultiplier.id
        params.version = -1
        controller.update()

        assert view == "/dateMultiplier/edit"
        assert model.dateMultiplierInstance != null
        assert model.dateMultiplierInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/dateMultiplier/list'

        response.reset()

        populateValidParams(params)
        def dateMultiplier = new DateMultiplier(params)

        assert dateMultiplier.save() != null
        assert DateMultiplier.count() == 1

        params.id = dateMultiplier.id

        controller.delete()

        assert DateMultiplier.count() == 0
        assert DateMultiplier.get(dateMultiplier.id) == null
        assert response.redirectedUrl == '/dateMultiplier/list'
    }
}
