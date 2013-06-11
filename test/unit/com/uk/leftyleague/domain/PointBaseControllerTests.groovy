package com.uk.leftyleague.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(PointBaseController)
@Mock(PointBase)
class PointBaseControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pointBase/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.pointBaseInstanceList.size() == 0
        assert model.pointBaseInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.pointBaseInstance != null
    }

    void testSave() {
        controller.save()

        assert model.pointBaseInstance != null
        assert view == '/pointBase/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pointBase/show/1'
        assert controller.flash.message != null
        assert PointBase.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pointBase/list'

        populateValidParams(params)
        def pointBase = new PointBase(params)

        assert pointBase.save() != null

        params.id = pointBase.id

        def model = controller.show()

        assert model.pointBaseInstance == pointBase
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pointBase/list'

        populateValidParams(params)
        def pointBase = new PointBase(params)

        assert pointBase.save() != null

        params.id = pointBase.id

        def model = controller.edit()

        assert model.pointBaseInstance == pointBase
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pointBase/list'

        response.reset()

        populateValidParams(params)
        def pointBase = new PointBase(params)

        assert pointBase.save() != null

        // test invalid parameters in update
        params.id = pointBase.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pointBase/edit"
        assert model.pointBaseInstance != null

        pointBase.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pointBase/show/$pointBase.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pointBase.clearErrors()

        populateValidParams(params)
        params.id = pointBase.id
        params.version = -1
        controller.update()

        assert view == "/pointBase/edit"
        assert model.pointBaseInstance != null
        assert model.pointBaseInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pointBase/list'

        response.reset()

        populateValidParams(params)
        def pointBase = new PointBase(params)

        assert pointBase.save() != null
        assert PointBase.count() == 1

        params.id = pointBase.id

        controller.delete()

        assert PointBase.count() == 0
        assert PointBase.get(pointBase.id) == null
        assert response.redirectedUrl == '/pointBase/list'
    }
}
